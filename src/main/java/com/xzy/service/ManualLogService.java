package com.xzy.service;

import com.xzy.model.ManualLog;

/**
 * Created by xzy on 2015-01-19 2:16 PM.
 */
public interface ManualLogService {
    public int addManaulLog(ManualLog manualLog);
    public int getManualLogNum(String time);
}
