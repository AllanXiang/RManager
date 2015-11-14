package com.xzy.model;

import com.xzy.util.Time;

import java.util.Date;

public class Server {
    private Integer serverId;

    private String serverIp;

    private Integer serverStatus;

    private String serverProvince;

    private String serverStime;

    private String serverOptime;

    public Integer getServerId() {
        return serverId;
    }

    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp == null ? null : serverIp.trim();
    }

    public Integer getServerStatus() {
        return serverStatus;
    }

    public void setServerStatus(Integer serverStatus) {
        this.serverStatus = serverStatus;
    }

    public String getServerProvince() {
        return serverProvince;
    }

    public void setServerProvince(String serverProvince) {
        this.serverProvince = serverProvince == null ? null : serverProvince.trim();
    }

    public String getServerStime() {
        return serverStime;
    }

    public void setServerStime(Date serverStime) {
        this.serverStime = Time.dateToString(serverStime);
    }

    public String getServerOptime() {
        return serverOptime;
    }

    public void setServerOptime(Date serverOptime) {
        this.serverOptime = Time.dateToString(serverOptime);
    }
}