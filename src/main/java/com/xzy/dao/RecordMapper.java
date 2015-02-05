package com.xzy.dao;

import com.xzy.model.Record;

import java.util.List;

public interface RecordMapper {
    int deleteByPrimaryKey(Integer recordId);

    int insert(Record record);

    int insertSelective(Record record);

    Record selectByPrimaryKey(Integer recordId);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);

    List<Record> getListByBatchId(Integer batchId);

    List<Record> getListResByBatchId(Integer batchId);

    int getOkNumById(Integer batchId);
}