package com.xzy.service.impl;

import com.alibaba.fastjson.JSON;
import com.xzy.dao.ServerMapper;
import com.xzy.model.Server;
import com.xzy.service.ServerService;
import com.xzy.util.FileManager;
import com.xzy.util.Global;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by xzy on 2015-01-09 7:55 PM.
 */
@Service("serverService")
public class ServerServiceImpl implements ServerService{
    private final static String dir = "/usr/local/openresty/nginx/xzy/tmp.conf";
    @Resource
    private ServerMapper serverMapper;

    @Override
    public Server getServerById(int serverId) {
        Server server = this.serverMapper.selectByPrimaryKey(serverId);
        Map<String, Integer> m =  (Map<String,Integer>) JSON.parse(server.getServerProvince());
        List<String> provincecode = Global.provincecode;
        String province = "";
        for(int i=0; i<provincecode.size(); i++){
            province += m.get(provincecode.get(i));
        }
        server.setServerProvince(province);
        return server;
    }

    @Override
    public List<Server> getServerList() {
        return this.serverMapper.getServerList();
    }

    @Override
    public List<String> getServerIpList() {
        return this.serverMapper.getServerIpList();
    }


    @Override
    public int upServer(Server server) {
        if(checkServer(server.getServerIp())) {
            int status = 0;
            if(server.getServerProvince() != null){
                status = this.serverMapper.updateByPrimaryKeySelective(setServer(server));
            }else{
                status = this.serverMapper.updateByPrimaryKeySelective(server);
            }
            if(status == 1){
                status = upNginx();
            }
            return status;
        }else{
            return -1;
        }
    }

    @Override
    public int addServer(Server server) {
        int status = this.serverMapper.insertSelective(setServer(server));
        if(status == 1){
            if(server.getServerStatus() == 1){
                status = upNginx();
            }else{
                this.serverMapper.deleteByPrimaryKey(server.getServerId());
            }
        }
        return status;
    }

    public int upNginx(){
        try {
            List<Server> list = this.serverMapper.getServerOKList();
            Map<String, List<String>> res = new HashMap<String, List<String>>();
            for (String province : Global.provincecode) {
                res.put(province, new ArrayList<String>());
            }
            for (Server server : list) {
                String ip = server.getServerIp();
                Map<String, Integer> m = (Map<String, Integer>) JSON.parse(server.getServerProvince());
                Iterator itor = m.entrySet().iterator();
                while (itor.hasNext()) {
                    Map.Entry entry = (Map.Entry) itor.next();
                    String province = (String) entry.getKey();
                    Integer val = (Integer) entry.getValue();
                    if (val == 1) {
                        List<String> tmp = res.get(province);
                        tmp.add(ip);
                    }
                }
            }
            Iterator itor = res.entrySet().iterator();
            while (itor.hasNext()) {
                Map.Entry entry = (Map.Entry) itor.next();
                String province = Global.pinyinmap.get((String) entry.getKey());
                StringBuilder toWrite = new StringBuilder("upstream "+province+ " {\n");
                List<String> ips = (List<String>) entry.getValue();
                for(String ip: ips){
                    toWrite.append("\tserver "+ip+";\n");
                }
                toWrite.append("}\n");
                FileManager.write(toWrite.toString(), dir, "utf-8");
            }
            //sh
            Process p = Runtime.getRuntime().exec("sh /usr/local/openresty/nginx/xzy/upServer.sh");
            p.waitFor();
            return 1;
        }catch(Exception e){
            return 0;
        }
    }

    public Server setServer(Server server){
        String province = server.getServerProvince();
        Map<String, Integer> m = new HashMap<String, Integer>();
        List<String> provincecode = Global.provincecode;
        for(int i=0; i<province.length(); i++){
            m.put(provincecode.get(i), Integer.parseInt(province.substring(i, i+1)));
        }
        server.setServerProvince(JSON.toJSONString(m));
        return server;
    }

    public boolean checkServer(String serverIp){
        int num =this.serverMapper.checkServerByIp(serverIp);
        return num==0;
    }
}
