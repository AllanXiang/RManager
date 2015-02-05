package com.xzy.service.impl;

import com.xzy.dao.CorpInfoMapper;
import com.xzy.dao.ManualLogMapper;
import com.xzy.model.CorpInfo;
import com.xzy.model.ManualLog;
import com.xzy.service.CorpInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xzy on 2015-01-17 1:01 PM.
 */
@Service("corpInfoService")
public class CorpInfoServiceImpl implements CorpInfoService{

    @Resource
    private CorpInfoMapper corpInfoMapper;
    @Resource
    private ManualLogMapper manualLogMapper;

    @Override
    public List<CorpInfo> getCorpInfoListByName(String corpname) {
        return this.corpInfoMapper.getCorpInfoListByName("%"+corpname+"%");
    }

    @Override
    public List<CorpInfo> getCorpInfoListByNo(String registerno) {
        return this.corpInfoMapper.getCorpInfoListByNo(registerno);
    }

    @Override
    public CorpInfo getCorpInfoById(int idcorpinfo) {
        return this.corpInfoMapper.selectByPrimaryKey(idcorpinfo);
    }

    @Override
    public int upCorpInfo(CorpInfo corpinfo) {
        ManualLog record = new ManualLog(corpinfo.getIdcorpinfo(), 9);
        int flagUp =  this.corpInfoMapper.updateByPrimaryKeySelective(corpinfo);
        int flagAdd = this.manualLogMapper.insertSelective(record);
        if(flagUp==1 && flagAdd==1){
            return 1;
        }else{
            return 0;
        }
    }
}
