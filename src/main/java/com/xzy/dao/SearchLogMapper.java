package com.xzy.dao;

import com.xzy.model.SearchLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SearchLogMapper {
    int deleteByPrimaryKey(Integer idsearchlog);

    int insert(SearchLog record);

    int insertSelective(SearchLog record);

    SearchLog selectByPrimaryKey(Integer idsearchlog);

    int updateByPrimaryKeySelective(SearchLog record);

    int updateByPrimaryKey(SearchLog record);

    List<SearchLog> getSearchLogList(String time);
    List<SearchLog> getSearchLogMonthList(String time);
    List<SearchLog> getSearchLogDashboardList(String time);
    List<SearchLog> getSearchLogConditionListByIp(@Param(value="time") String time, @Param(value="ip") String ip);
}