package com.xzy.model.Statistics;

import java.util.List;

/**
 * Created by xzy on 2015-01-17 9:06 PM.
 */
public class Statistics {
    private String ip;
    private List<Condition> condition;
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public List<Condition> getCondition() {
        return condition;
    }
    public void setCondition(List<Condition> condition) {
        this.condition = condition;
    }
}



