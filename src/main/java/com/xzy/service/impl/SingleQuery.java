package com.xzy.service.impl;

import com.alibaba.fastjson.JSON;
import com.xzy.model.Record;
import com.xzy.util.Connect;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * Created by xzy on 2015/11/10.
 */
public class SingleQuery implements Callable<String> {
    private static Logger logger = Logger.getLogger(SingleQuery.class);
    private Record r = null;
    public SingleQuery(Record record){
        this.r = record;
    }

    public String getXml(String corpName, String province, String regCode){
        Connect c = new Connect();
        String xml = c.post(corpName, province, regCode);
        return xml;
    }

    @Override
    public String call(){
        String corpName = r.getRecordInputCorpname();
        String province = r.getRecordInputProvince();
        String regCode = r.getRecordInputCode();
        String xml = getXml(corpName, province, regCode);

        Document doc = null;
        try{
            doc = DocumentHelper.parseText(xml);
            Element rootElt = doc.getRootElement();
            Element base = rootElt.element("corpBaseNationalInfo");
            int flag = Integer.parseInt(base.attributeValue("treatResult"));
            if(flag==1){
                Element item = base.element("item");
                r.setRecordOutputCorpname(item.elementTextTrim("corpName"));
                r.setRecordOutputName(item.elementTextTrim("artificialName"));
                r.setRecordOutputCode(item.elementTextTrim("registerNo"));
                r.setRecordOutputStatus(item.elementTextTrim("status"));
                r.setRecordOutputRegisterdate(item.elementTextTrim("registDate"));
                r.setRecordOutputRegisterfund(item.elementTextTrim("registFund"));
                String range = item.elementTextTrim("manageRange");
                if(range.length() > 200){
                    r.setRecordOutputRange(range.substring(0, 200));
                }else {
                    r.setRecordOutputRange(range);
                }
                r.setRecordOutputOpendate(item.elementTextTrim("openDate"));
                r.setRecordOutputManageopendate(item.elementTextTrim("manageBeginDate"));
                r.setRecordOutputManageenddate(item.elementTextTrim("manageEndDate"));
                r.setRecordOutputCompanytype(item.elementTextTrim("corpType"));
                r.setRecordOutputRegisterorgan(item.elementTextTrim("registerDepartment"));
                r.setRecordOutputRegisteraddress(item.elementTextTrim("registerAddress"));
            }else{
//                r.setRecordOutputStatus(Global.searchcondition.get(flag));
            }
            r.setRecordStatus(flag);
            r.setRecordTime(new Date());
        } catch (DocumentException e){
            logger.error("xml DocumentException error "+xml);
            r.setRecordStatus(3);
            r.setRecordTime(new Date());
        } catch (Exception e){
            logger.error("xml other error"+xml);
            r.setRecordStatus(3);
            r.setRecordTime(new Date());
        }
        return JSON.toJSONString(r);
    }
}
