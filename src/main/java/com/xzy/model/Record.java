package com.xzy.model;

import java.util.Date;

public class Record {
    private Integer recordId;

    private Date recordTime;

    private String recordInputCorpname;

    private String recordInputCode;

    private String recordInputProvince;

    private String recordOutputCorpname;

    private String recordOutputName;

    private String recordOutputStatus;

    private String recordOutputCode;

    private String recordOutputRegisterdate;

    private String recordOutputRegisterfund;

    private String recordOutputRange;

    private String recordOutputOpendate;

    private String recordOutputManageopendate;

    private String recordOutputManageenddate;

    private String recordOutputCompanytype;

    private String recordOutputRegisterorgan;

    private String recordOutputRegisteraddress;

    private Integer recordStatus;

    private Integer recordBatchId;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public String getRecordInputCorpname() {
        return recordInputCorpname;
    }

    public void setRecordInputCorpname(String recordInputCorpname) {
        this.recordInputCorpname = recordInputCorpname == null ? null : recordInputCorpname.trim();
    }

    public String getRecordInputCode() {
        return recordInputCode;
    }

    public void setRecordInputCode(String recordInputCode) {
        this.recordInputCode = recordInputCode == null ? null : recordInputCode.trim();
    }

    public String getRecordInputProvince() {
        return recordInputProvince;
    }

    public void setRecordInputProvince(String recordInputProvince) {
        this.recordInputProvince = recordInputProvince == null ? null : recordInputProvince.trim();
    }

    public String getRecordOutputCorpname() {
        return recordOutputCorpname;
    }

    public void setRecordOutputCorpname(String recordOutputCorpname) {
        this.recordOutputCorpname = recordOutputCorpname == null ? null : recordOutputCorpname.trim();
    }

    public String getRecordOutputName() {
        return recordOutputName;
    }

    public void setRecordOutputName(String recordOutputName) {
        this.recordOutputName = recordOutputName == null ? null : recordOutputName.trim();
    }

    public String getRecordOutputStatus() {
        return recordOutputStatus;
    }

    public void setRecordOutputStatus(String recordOutputStatus) {
        this.recordOutputStatus = recordOutputStatus == null ? null : recordOutputStatus.trim();
    }

    public String getRecordOutputCode() {
        return recordOutputCode;
    }

    public void setRecordOutputCode(String recordOutputCode) {
        this.recordOutputCode = recordOutputCode == null ? null : recordOutputCode.trim();
    }

    public String getRecordOutputRegisterdate() {
        return recordOutputRegisterdate;
    }

    public void setRecordOutputRegisterdate(String recordOutputRegisterdate) {
        this.recordOutputRegisterdate = recordOutputRegisterdate == null ? null : recordOutputRegisterdate.trim();
    }

    public String getRecordOutputRegisterfund() {
        return recordOutputRegisterfund;
    }

    public void setRecordOutputRegisterfund(String recordOutputRegisterfund) {
        this.recordOutputRegisterfund = recordOutputRegisterfund == null ? null : recordOutputRegisterfund.trim();
    }

    public String getRecordOutputRange() {
        return recordOutputRange;
    }

    public void setRecordOutputRange(String recordOutputRange) {
        this.recordOutputRange = recordOutputRange == null ? null : recordOutputRange.trim();
    }

    public String getRecordOutputOpendate() {
        return recordOutputOpendate;
    }

    public void setRecordOutputOpendate(String recordOutputOpendate) {
        this.recordOutputOpendate = recordOutputOpendate == null ? null : recordOutputOpendate.trim();
    }

    public String getRecordOutputManageopendate() {
        return recordOutputManageopendate;
    }

    public void setRecordOutputManageopendate(String recordOutputManageopendate) {
        this.recordOutputManageopendate = recordOutputManageopendate == null ? null : recordOutputManageopendate.trim();
    }

    public String getRecordOutputManageenddate() {
        return recordOutputManageenddate;
    }

    public void setRecordOutputManageenddate(String recordOutputManageenddate) {
        this.recordOutputManageenddate = recordOutputManageenddate == null ? null : recordOutputManageenddate.trim();
    }

    public String getRecordOutputCompanytype() {
        return recordOutputCompanytype;
    }

    public void setRecordOutputCompanytype(String recordOutputCompanytype) {
        this.recordOutputCompanytype = recordOutputCompanytype == null ? null : recordOutputCompanytype.trim();
    }

    public String getRecordOutputRegisterorgan() {
        return recordOutputRegisterorgan;
    }

    public void setRecordOutputRegisterorgan(String recordOutputRegisterorgan) {
        this.recordOutputRegisterorgan = recordOutputRegisterorgan == null ? null : recordOutputRegisterorgan.trim();
    }

    public String getRecordOutputRegisteraddress() {
        return recordOutputRegisteraddress;
    }

    public void setRecordOutputRegisteraddress(String recordOutputRegisteraddress) {
        this.recordOutputRegisteraddress = recordOutputRegisteraddress == null ? null : recordOutputRegisteraddress.trim();
    }

    public Integer getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Integer recordStatus) {
        this.recordStatus = recordStatus;
    }

    public Integer getRecordBatchId() {
        return recordBatchId;
    }

    public void setRecordBatchId(Integer recordBatchId) {
        this.recordBatchId = recordBatchId;
    }
}