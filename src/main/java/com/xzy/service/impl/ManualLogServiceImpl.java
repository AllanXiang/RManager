package com.xzy.service.impl;

import com.xzy.dao.ManualLogMapper;
import com.xzy.model.ManualLog;
import com.xzy.service.ManualLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by xzy on 2015-01-19 2:17 PM.
 */
@Service("manualLogService")
public class ManualLogServiceImpl implements ManualLogService{

    @Resource
    private ManualLogMapper manualLogMapper;

    @Override
    public int addManaulLog(ManualLog manualLog) {
        return this.manualLogMapper.insertSelective(manualLog);
    }

    @Override
    public int getManualLogNum(String time) {
        return this.manualLogMapper.getManualLogNum(time);
    }
}
