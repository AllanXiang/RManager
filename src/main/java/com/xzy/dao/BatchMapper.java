package com.xzy.dao;

import com.xzy.model.Batch;

import java.util.List;

public interface BatchMapper {
    int deleteByPrimaryKey(Integer batchId);

    int insert(Batch record);

    int insertSelective(Batch record);

    Batch selectByPrimaryKey(Integer batchId);

    int updateByPrimaryKeySelective(Batch record);

    int updateByPrimaryKey(Batch record);

    List<Batch> getBatchList();

    Batch getLatest();
}