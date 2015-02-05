package com.xzy.model;

import java.util.Date;

public class ManualLog {
    private Integer manualId;

    private Integer corpinfoId;

    private Integer searchcondition;

    private Date manualTime;

    public Integer getManualId() {
        return manualId;
    }

    public void setManualId(Integer manualId) {
        this.manualId = manualId;
    }

    public Integer getCorpinfoId() {
        return corpinfoId;
    }

    public void setCorpinfoId(Integer corpinfoId) {
        this.corpinfoId = corpinfoId;
    }

    public Integer getSearchcondition() {
        return searchcondition;
    }

    public void setSearchcondition(Integer searchcondition) {
        this.searchcondition = searchcondition;
    }

    public Date getManualTime() {
        return manualTime;
    }

    public void setManualTime(Date maualTime) {
        this.manualTime = maualTime;
    }

    public ManualLog(Integer corpinfoId, Integer searchcondition){
        this.corpinfoId = corpinfoId;
        this.searchcondition = searchcondition;
    }
}