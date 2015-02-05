package com.xzy.service;

import com.xzy.model.CorpInfo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xzy on 2015-01-08 8:38 PM.
 */
public interface CorpInfoService {
    public List<CorpInfo> getCorpInfoListByName(String corpname);
    public List<CorpInfo> getCorpInfoListByNo(String registerno);
    public CorpInfo getCorpInfoById(int idcorpinfo);
    @Transactional
    public int upCorpInfo(CorpInfo corpinfo);
}
