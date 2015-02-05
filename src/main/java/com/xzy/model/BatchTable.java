package com.xzy.model;

/**
 * Created by xzy on 2015-01-30 3:53 PM.
 */
public class BatchTable {

    public String getBatchFilename() {
        return batchFilename;
    }

    public void setBatchFilename(String batchFilename) {
        this.batchFilename = batchFilename;
    }

    public String getBatchStime() {
        return batchStime;
    }

    public void setBatchStime(String batchStime) {
        this.batchStime = batchStime;
    }

    public String getBatchEtime() {
        return batchEtime;
    }

    public void setBatchEtime(String batchEtime) {
        this.batchEtime = batchEtime;
    }

    public String getBatchStatus() {
        return batchStatus;
    }

    public void setBatchStatus(String batchStatus) {
        this.batchStatus = batchStatus;
    }

    public String getBatchUrl() {
        return batchUrl;
    }

    public void setBatchUrl(int batchUrl) {
        this.batchUrl = "<a href='/file/api/download/" + batchUrl + "'>下载</a>";
    }

    private String batchUrl;

    private String batchFilename;

    private String batchStime;

    private String batchEtime;

    private String batchStatus;

}
