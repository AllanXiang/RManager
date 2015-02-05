package com.xzy.service.impl;

import com.xzy.dao.SearchLogMapper;
import com.xzy.dao.ServerMapper;
import com.xzy.model.Statistics.Condition;
import com.xzy.model.Statistics.Statistics;
import com.xzy.model.SearchLog;
import com.xzy.service.SearchLogService;
import com.xzy.util.Global;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by xzy on 2015-01-09 7:55 PM.
 */
@Service("searchLogService")
public class SearchLogServiceImpl implements SearchLogService {
    @Resource
    private SearchLogMapper searchLogMapper;
    @Resource
    private ServerMapper serverMapper;

    @Override
    public List<SearchLog> getSearchLogList(String time) {
        return searchLogMapper.getSearchLogList(time);
    }

    @Override
    public List<SearchLog> getSearchLogMonthList(String time) {
        return searchLogMapper.getSearchLogMonthList(time);
    }

    @Override
    public List<Statistics> getDashboard(String time) {
        List<String> iplist = this.serverMapper.getServerIpList();
        Map<String,String> allip = new HashMap<String, String>();
        for(String ip : iplist){
            allip.put(ip, "");
        }
        Map<String, Integer> m = new HashMap<String, Integer>();
        Iterator itor = allip.entrySet().iterator();
        while (itor.hasNext()) {
            Map.Entry entry = (Map.Entry) itor.next();
            String ip = (String) entry.getKey();
            for (int i = 0; i < 24; i++) {
                m.put(ip + i + "ok", 0);
                m.put(ip + i + "error", 0);
            }
        }

        List<SearchLog> logs = this.searchLogMapper.getSearchLogDashboardList(time);
        for(SearchLog log: logs){
            int flag = log.getSearchcondition();
            String ip = log.getLocalip();
            int hh = Integer.parseInt(log.getStarttime().substring(11, 13));
            if (ip == null || allip.get(ip) == null) {
                continue;
            }
            String key = ip + hh;
            if (flag == 1 || flag == 2 || flag == 4) {
                m.put(key + "ok", m.get(key + "ok") + 1);
            } else {
                m.put(key + "error", m.get(key + "error") + 1);
            }
        }

        List<Statistics> res = new ArrayList<Statistics>();
        itor = allip.entrySet().iterator();
        while (itor.hasNext()) {
            Map.Entry entry = (Map.Entry)itor.next();
            String ip = (String) entry.getKey();
            Statistics statistics = new Statistics();
            statistics.setIp(ip);
            List<Condition> listcondition = new ArrayList<Condition>();
            statistics.setCondition(listcondition);
            for (int i = 0; i < 24; i++) {
                int ok = m.get(ip + i + "ok");
                int error = m.get(ip + i + "error");
                Condition c = new Condition();
                c.setError(error);
                c.setOk(ok);
                c.setTot(error + ok);
                c.setTime(i + "");
                listcondition.add(c);
            }
            res.add(statistics);
        }
        return res;
    }

    @Override
    public Statistics getProvinceStatistics(String time, String ip) {
        Map<String, Integer> m = new HashMap<String, Integer>();
        List<String> provincecode = Global.provincecode;
        for (int i = 0; i < 31; i++) {
            String code = provincecode.get(i);
            m.put(code + "ok", 0);
            m.put(code + "error", 0);
        }
        List<SearchLog> logs = this.searchLogMapper.getSearchLogConditionListByIp(time, ip);
        for(SearchLog log: logs){
            int flag = log.getSearchcondition();
            String code = log.getProvince();
            if (flag == 1 || flag == 2 || flag == 4) {
                m.put(code + "ok", m.get(code + "ok") + 1);
            } else {
                m.put(code + "error", m.get(code + "error") + 1);
            }
        }

        Map<String, String> mprovince = Global.provincelist;
        List<Condition> listcondition = new ArrayList<Condition>();
        for (int i = 0; i < 31; i++) {
            String code = provincecode.get(i);
            int ok = m.get(code + "ok");
            int error = m.get(code + "error");
            Condition c = new Condition();
            c.setError(error);
            c.setOk(ok);
            c.setTot(error + ok);
            c.setTime(mprovince.get(code));
            listcondition.add(c);
        }
        Statistics statistics = new Statistics();
        statistics.setIp(ip);
        statistics.setCondition(listcondition);

        return statistics;
    }

}
