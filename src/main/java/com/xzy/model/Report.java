package com.xzy.model;

public class Report {

    private Integer reportId;

    private String reportTime;

    private Integer reportTotNum;

    private Integer reportOkNum;

    private Integer reportErrorNum;

    private Integer reportManualNum;

    private Float reportAvgTime;

    private String reportRate;

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    public Integer getReportTotNum() {
        return reportTotNum;
    }

    public void setReportTotNum(Integer reportTotNum) {
        this.reportTotNum = reportTotNum;
    }

    public Integer getReportOkNum() {
        return reportOkNum;
    }

    public void setReportOkNum(Integer reportOkNum) {
        this.reportOkNum = reportOkNum;
    }

    public Integer getReportErrorNum() {
        return reportErrorNum;
    }

    public void setReportErrorNum(Integer reportErrorNum) {
        this.reportErrorNum = reportErrorNum;
    }

    public Integer getReportManualNum() {
        return reportManualNum;
    }

    public void setReportManualNum(Integer reportManualNum) {
        this.reportManualNum = reportManualNum;
    }

    public Float getReportAvgTime() {
        return reportAvgTime;
    }

    public void setReportAvgTime(Float reportAvgTime) {
        this.reportAvgTime = reportAvgTime;
    }

    public String getReportRate() {
        return reportRate;
    }

    public void setReportRate(String reportRate) {
        this.reportRate = reportRate == null ? null : reportRate.trim();
    }
}