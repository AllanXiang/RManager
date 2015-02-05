package com.xzy.model;

import com.xzy.util.Time;

import java.util.Date;

public class Batch {
    private Integer batchId;

    private String batchFilename;

    private String batchStime;

    private String batchEtime;

    private Integer batchStatus;

    private String batchDir;

    private Integer batchNum;

    public Integer getBatchNum() {
        return batchNum;
    }

    public void setBatchNum(Integer batchNum) {
        this.batchNum = batchNum;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public String getBatchFilename() {
        return batchFilename;
    }

    public void setBatchFilename(String batchFilename) {
        this.batchFilename = batchFilename == null ? null : batchFilename.trim();
    }

    public String getBatchStime() {
        return batchStime;
    }

    public void setBatchStime(Date batchStime) {
        this.batchStime = Time.dateToString(batchStime);
    }

    public String getBatchEtime() {
        return batchEtime;
    }

    public void setBatchEtime(Date batchEtime) {
        this.batchEtime = Time.dateToString(batchEtime);
    }

    public Integer getBatchStatus() {
        return batchStatus;
    }

    public void setBatchStatus(Integer batchStatus) {
        this.batchStatus = batchStatus;
    }

    public String getBatchDir() {
        return batchDir;
    }

    public void setBatchDir(String batchDir) {
        this.batchDir = batchDir == null ? null : batchDir.trim();
    }
}