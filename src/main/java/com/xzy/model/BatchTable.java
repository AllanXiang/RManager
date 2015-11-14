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

    private String batchOp;
    private String batchDel;
    public String getBatchOp() {
        return batchOp;
    }

    public void setBatchOp(int batchId, int batchStatus) {
        if(batchStatus == 1){
            this.batchOp = "<input type=\"button\" class='btn btn-inverse' value=\"完成\">";
        }else if(batchStatus == -2){
            this.batchOp = "<input onclick=\"return upBatch(" + batchId + ", -1)\" type=\"button\" class='btn btn-danger' value=\"暂停\">";
        }else if(batchStatus == -1) {
            this.batchOp = "<input onclick=\"return upBatch(" + batchId + ", -2)\" type=\"button\" class='btn btn-warning' value=\"待运行\">";
        }else if(batchStatus == 0){
            this.batchOp = "<input onclick=\"return upBatch(" + batchId + ", -2)\" type=\"button\" class='btn btn-success' value=\"运行\">";
        }
    }

    public String getBatchDel() {
        return batchDel;
    }

    public void setBatchDel(int batchId) {
        this.batchDel = "<a onclick=\"return upBatch(" + batchId + ", -3)\" title=\"删除\" class=\"btn btn-mini tip theme-login\"> " +
                "<img src=\"../img/icons/essen/16/busy.png\" alt=\"\"> </a>";
    }
}
