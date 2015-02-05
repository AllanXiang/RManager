package com.xzy.service;

import com.xzy.model.Statistics.Statistics;
import com.xzy.model.SearchLog;

import java.util.List;

/**
 * Created by xzy on 2015-01-08 8:38 PM.
 */
public interface SearchLogService {
    public List<SearchLog> getSearchLogList(String time);
    public List<SearchLog> getSearchLogMonthList(String time);
    public List<Statistics> getDashboard(String time);
    public Statistics getProvinceStatistics(String time, String ip);
}
