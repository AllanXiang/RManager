package com.xzy.dao;

import com.xzy.model.Server;

import java.util.List;

public interface ServerMapper {
    int deleteByPrimaryKey(Integer serverId);

    int insert(Server record);

    int insertSelective(Server record);

    Server selectByPrimaryKey(Integer serverId);

    int updateByPrimaryKeySelective(Server record);

    int updateByPrimaryKey(Server record);

    List<Server> getServerList();
    List<Server> getServerOKList();

    List<String> getServerIpList();

    int checkServerByIp(String localip);
}