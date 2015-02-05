package com.xzy.dao;

import com.xzy.model.CorpInfo;

import java.util.List;

public interface CorpInfoMapper {
    int deleteByPrimaryKey(Integer idcorpinfo);

    int insert(CorpInfo record);

    int insertSelective(CorpInfo record);

    CorpInfo selectByPrimaryKey(Integer idcorpinfo);

    int updateByPrimaryKeySelective(CorpInfo record);

    int updateByPrimaryKeyWithBLOBs(CorpInfo record);

    int updateByPrimaryKey(CorpInfo record);

    List<CorpInfo> getCorpInfoListByName(String corpname);

    List<CorpInfo> getCorpInfoListByNo(String registerno);
}