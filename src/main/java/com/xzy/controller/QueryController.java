package com.xzy.controller;

import com.xzy.model.Batch;
import com.xzy.model.BatchTable;
import com.xzy.service.QueryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xzy on 2015-01-08 8:52 PM.
 */
@Controller
public class QueryController {
    @Resource
    private QueryService queryService;

    @RequestMapping(value = "/query/api/single", method = RequestMethod.POST)
    public @ResponseBody
    String queryAPI(@RequestParam(value = "corpName", required = false) String corpName,
                             @RequestParam(value = "regCode", required = false) String regCode,
                             @RequestParam(value = "province") String province) {

        return this.queryService.getQueryResult(corpName,province,regCode);
    }

    @RequestMapping(value = "/guest")
    public String guest(){
        return "guest";
    }


    @RequestMapping(value = "/online")
    public String online(){
        return "online";
    }

    @RequestMapping(value = "/query/api/batch", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> getBatch(){
        List<Batch> batchs = this.queryService.getBatchList();
        List<BatchTable> list = new ArrayList<BatchTable>();
        for(Batch batch: batchs){
            BatchTable t = new BatchTable();
            t.setBatchEtime(batch.getBatchEtime());
            t.setBatchStime(batch.getBatchStime());
            t.setBatchFilename(batch.getBatchFilename());
            int id = batch.getBatchId();
            t.setBatchUrl(id);
            t.setBatchDel(id);
            int status = batch.getBatchStatus() % 10 - 3;
            int ok_num = batch.getBatchStatus() / 10;
            int num = batch.getBatchNum();
            t.setBatchStatus(ok_num + "/" + num);
            t.setBatchOp(id, status);
            list.add(t);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", list);
        return map;
    }

    @RequestMapping(value = "/query/api/batch/{id}", method = RequestMethod.PUT)
    public @ResponseBody
    String upBatchAPI(@RequestBody Batch batch){
        int status = this.queryService.upBatch(batch);
        return status+"";
    }
}
