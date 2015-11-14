package com.xzy.service.impl;

import com.alibaba.fastjson.JSON;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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

    @Override
    public String getQueryResult(String corpName, String province, String regCode) {
        QueryUtils qutil = new QueryUtils();
        String output = qutil.XMLToHTMLTable(getXml(corpName, province, regCode));
        return output;
    }
    private static int THREAD_POOL_SIZE = 3;
    @Resource
    private RecordMapper recordMapper;
    @Resource
    private BatchMapper batchMapper;
    private Random random = new Random();

//    public Record getXmlResult(Record r){
//        String corpName = r.getRecordInputCorpname();
//        String province = r.getRecordInputProvince();
//        String regCode = r.getRecordInputCode();
//        String xml = getXml(corpName, province, regCode);
//
//        Document doc = null;
//        try{
//            doc = DocumentHelper.parseText(xml);
//            Element rootElt = doc.getRootElement();
//            Element base = rootElt.element("corpBaseNationalInfo");
//            int flag = Integer.parseInt(base.attributeValue("treatResult"));
//            if(flag==1){
//                Element item = base.element("item");
//                r.setRecordOutputCorpname(item.elementTextTrim("corpName"));
//                r.setRecordOutputName(item.elementTextTrim("artificialName"));
//                r.setRecordOutputCode(item.elementTextTrim("registerNo"));
//                r.setRecordOutputStatus(item.elementTextTrim("status"));
//                r.setRecordOutputRegisterdate(item.elementTextTrim("registDate"));
//                r.setRecordOutputRegisterfund(item.elementTextTrim("registFund"));
//                String range = item.elementTextTrim("manageRange");
//                if(range.length() > 200){
//                    r.setRecordOutputRange(range.substring(0, 200));
//                }else {
//                    r.setRecordOutputRange(range);
//                }
//                r.setRecordOutputOpendate(item.elementTextTrim("openDate"));
//                r.setRecordOutputManageopendate(item.elementTextTrim("manageBeginDate"));
//                r.setRecordOutputManageenddate(item.elementTextTrim("manageEndDate"));
//                r.setRecordOutputCompanytype(item.elementTextTrim("corpType"));
//                r.setRecordOutputRegisterorgan(item.elementTextTrim("registerDepartment"));
//                r.setRecordOutputRegisteraddress(item.elementTextTrim("registerAddress"));
//            }else{
////                r.setRecordOutputStatus(Global.searchcondition.get(flag));
//            }
//            r.setRecordStatus(flag);
//            r.setRecordTime(new Date());
//        } catch (DocumentException e){
//            logger.error("xml DocumentException error "+xml);
//            r.setRecordStatus(3);
//            r.setRecordTime(new Date());
//        } catch (Exception e){
//            logger.error("xml other error"+xml);
//            r.setRecordStatus(3);
//            r.setRecordTime(new Date());
//        }
//        return r;
//    }

    @Override
    public void getMulQueryResult() {
        Batch batch = this.batchMapper.getLatest();
        if(batch == null){

        }else{
            int id = batch.getBatchId();
            int num = batch.getBatchNum();
            batch.setBatchStatus(0);
            this.batchMapper.updateByPrimaryKeySelective(batch);
            logger.info("---start batch---"+id);
            List<Record> records = this.recordMapper.getListByBatchId(id);
            //shuffle
            int submit_num = records.size();
            int[] arr = new int[submit_num];
            for(int i = 0; i < submit_num; i++){
                arr[i] = i;
            }
            for(int i = submit_num - 1; i > 0; i--){
                int j = random.nextInt(i);
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
            //submit executor service
            ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
            ArrayList<Future<String>> al = new ArrayList<Future<String>>();
            for(int i = 0; i < submit_num; i++){
//                Record r = records.get(arr[i]);
//                Record res = getXmlResult(r);
//                this.recordMapper.updateByPrimaryKeySelective(res);
                al.add(executor.submit(new SingleQuery(records.get(arr[i]))));
            }
            for (Future<String> fs : al) {
                try {
                    Record res = JSON.parseObject(fs.get(), Record.class);
                    this.recordMapper.updateByPrimaryKeySelective(res);
                } catch (InterruptedException e) {
                    logger.error(e);
                } catch (ExecutionException e) {
                    logger.error(e);
                }
            }
            executor.shutdown();

            if(this.recordMapper.getOkNumById(id) == num) {
                batch.setBatchStatus(1);
                batch.setBatchEtime(new Date());
                this.batchMapper.updateByPrimaryKeySelective(batch);
            }else{
                Batch batch2 = this.batchMapper.selectByPrimaryKey(id);
                if(batch2.getBatchStatus() == 0){
                    batch.setBatchStatus(-1);
                    this.batchMapper.updateByPrimaryKeySelective(batch);
                }
            }
            logger.info("---end batch---"+id);
        }
    }

    @Override
    public List<Batch> getBatchList() {
        List<Batch> batchs = this.batchMapper.getBatchList();
        for(Batch batch: batchs){
            int num = this.recordMapper.getOkNumById(batch.getBatchId());
            batch.setBatchStatus(batch.getBatchStatus() + 3 + num * 10);
        }
        return batchs;
    }

    @Override
    public int upBatch(Batch batch) {
        int status = this.batchMapper.updateByPrimaryKeySelective(batch);
        return status;
    }
}
