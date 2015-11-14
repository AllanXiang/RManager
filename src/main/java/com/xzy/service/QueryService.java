package com.xzy.service;

import com.xzy.model.Batch;

import java.util.List;

/**
 * Created by xzy on 2015-01-17 3:17 PM.
 */
public interface QueryService {
    public String getQueryResult(String corpName, String province, String regCode);
    public void getMulQueryResult();
    public List<Batch> getBatchList();
    public int upBatch(Batch batch);
}
