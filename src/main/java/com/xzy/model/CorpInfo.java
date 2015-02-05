package com.xzy.model;

import com.xzy.util.Global;
import com.xzy.util.Time;

import java.util.Date;

public class CorpInfo {
    private Integer idcorpinfo;

    private String province;

    private String corpname;

    private String registerno;

    private String inserttime;

    private String detail;

    public Integer getIdcorpinfo() {
        return idcorpinfo;
    }

    public void setIdcorpinfo(Integer idcorpinfo) {
        this.idcorpinfo = idcorpinfo;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = Global.provincelist.get(province.trim());
    }

    public String getCorpname() {
        return corpname;
    }

    public void setCorpname(String corpname) {
        this.corpname = corpname == null ? null : corpname.trim();
    }

    public String getRegisterno() {
        return registerno;
    }

    public void setRegisterno(String registerno) {
        this.registerno = registerno == null ? null : registerno.trim();
    }

    public String getInserttime() {
        return inserttime;
    }

    public void setInserttime(Date inserttime) {
        this.inserttime = Time.dateToString(inserttime);
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}