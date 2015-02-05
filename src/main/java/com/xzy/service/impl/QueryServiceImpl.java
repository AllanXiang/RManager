package com.xzy.service.impl;

import com.xzy.dao.BatchMapper;
import com.xzy.dao.RecordMapper;
import com.xzy.model.Batch;
import com.xzy.model.Record;
import com.xzy.service.QueryService;
import com.xzy.util.Connect;
import com.xzy.util.Global;
import com.xzy.util.QueryUtils;
import org.apache.log4j.Logger;

import org.springframework.stereotype.Service;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by xzy on 2015-01-08 8:47 PM.
 */
@Service("queryService")
public class QueryServiceImpl implements QueryService {
    private static Logger logger = Logger.getLogger(QueryServiceImpl.class);

    public String getXml(String corpName, String province, String regCode){
        Connect c = new Connect();
        String xml = c.post(corpName, province, regCode);
        return xml;
    }

    public Record getXmlResult(Record r){
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
                r.setRecordOutputRange(item.elementTextTrim("manageRange"));
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
        } catch (Exception e){
            logger.error("xml other error"+xml);
        }
        return r;
    }

    @Override
    public String getQueryResult(String corpName, String province, String regCode) {
        QueryUtils qutil = new QueryUtils();
        String output = qutil.XMLToHTMLTable(getXml(corpName, province, regCode));
        return output;
    }

    @Resource
    private RecordMapper recordMapper;
    @Resource
    private BatchMapper batchMapper;

    @Override
    public void getMulQueryResult() {
        Batch batch = this.batchMapper.getLatest();
        if(batch == null){

        }else{
            int id = batch.getBatchId();
            batch.setBatchStatus(0);
            this.batchMapper.updateByPrimaryKeySelective(batch);
            logger.info("---start batch---"+id);
            List<Record> records = this.recordMapper.getListByBatchId(id);
            for(Record r: records){
                Record res = getXmlResult(r);
                this.recordMapper.updateByPrimaryKeySelective(res);
            }
            if(this.recordMapper.getOkNumById(id)==batch.getBatchNum()) {
                batch.setBatchStatus(1);
                batch.setBatchEtime(new Date());
                this.batchMapper.updateByPrimaryKeySelective(batch);
            }else{
                batch.setBatchStatus(-1);
                this.batchMapper.updateByPrimaryKeySelective(batch);
            }
            logger.info("---end batch---"+id);
        }
    }

    @Override
    public List<Batch> getBatchList() {
        List<Batch> batchs = this.batchMapper.getBatchList();
        for(Batch batch: batchs){
            int num = this.recordMapper.getOkNumById(batch.getBatchId());
            batch.setBatchStatus(num);
        }
        return batchs;
    }
}
