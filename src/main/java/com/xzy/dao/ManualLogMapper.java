package com.xzy.dao;

import com.xzy.model.ManualLog;

public interface ManualLogMapper {
    int deleteByPrimaryKey(Integer manualId);

    int insert(ManualLog record);

    int insertSelective(ManualLog record);

    ManualLog selectByPrimaryKey(Integer manualId);

    int updateByPrimaryKeySelective(ManualLog record);

    int updateByPrimaryKey(ManualLog record);

    int getManualLogNum(String time);
}