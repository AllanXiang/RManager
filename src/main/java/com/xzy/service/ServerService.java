package com.xzy.service;

import com.xzy.model.Server;

import java.util.List;

/**
 * Created by xzy on 2015-01-09 7:53 PM.
 */
public interface ServerService {
    public Server getServerById(int serverId);
    public List<Server> getServerList();
    public List<String> getServerIpList();
    public int upServer(Server server);
    public int addServer(Server server);
}
