package com.xzy.model;

import com.xzy.util.Global;
import com.xzy.util.Time;

import java.util.Date;

public class SearchLog {
    private Integer idsearchlog;

    private String refid;

    private String province;

    private String registerid;

    private String corpname;

    private String starttime;

    private Date endtime;

    private Integer spendtime;

    private Integer searchcondition;

    private String treaterrorcode;

    private String errormessage;

    private Integer searchnumber;

    private String userip;

    private String localip;

    private Integer idcorpinfo;

    public Integer getIdsearchlog() {
        return idsearchlog;
    }

    public void setIdsearchlog(Integer idsearchlog) {
        this.idsearchlog = idsearchlog;
    }

    public String getRefid() {
        return refid;
    }

    public void setRefid(String refid) {
        this.refid = refid == null ? null : refid.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province.trim();
    }

    public String getRegisterid() {
        return registerid;
    }

    public void setRegisterid(String registerid) {
        this.registerid = registerid == null ? null : registerid.trim();
    }

    public String getCorpname() {
        return corpname;
    }

    public void setCorpname(String corpname) {
        this.corpname = corpname == null ? null : corpname.trim();
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = Time.dateToString(starttime);
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getSpendtime() {
        return spendtime;
    }

    public void setSpendtime(Integer spendtime) {
        this.spendtime = spendtime;
    }

    public Integer getSearchcondition() {
        return searchcondition;
    }

    public void setSearchcondition(Integer searchcondition) {
        this.searchcondition = searchcondition;
    }

    public String getTreaterrorcode() {
        return treaterrorcode;
    }

    public void setTreaterrorcode(String treaterrorcode) {
        this.treaterrorcode = treaterrorcode == null ? null : treaterrorcode.trim();
    }

    public String getErrormessage() {
        return errormessage;
    }

    public void setErrormessage(String errormessage) {
        this.errormessage = errormessage == null ? null : errormessage.trim();
    }

    public Integer getSearchnumber() {
        return searchnumber;
    }

    public void setSearchnumber(Integer searchnumber) {
        this.searchnumber = searchnumber;
    }

    public String getUserip() {
        return userip;
    }

    public void setUserip(String userip) {
        this.userip = userip == null ? null : userip.trim();
    }

    public String getLocalip() {
        return localip;
    }

    public void setLocalip(String localip) {
        this.localip = localip == null ? null : localip.trim();
    }

    public Integer getIdcorpinfo() {
        return idcorpinfo;
    }

    public void setIdcorpinfo(Integer idcorpinfo) {
        this.idcorpinfo = idcorpinfo;
    }
}