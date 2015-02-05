package com.xzy.dao;

import com.xzy.model.Report;

import java.util.List;

public interface ReportMapper {
    int deleteByPrimaryKey(Integer reportId);

    int insert(Report record);

    int insertSelective(Report record);

    Report selectByPrimaryKey(Integer reportId);

    int updateByPrimaryKeySelective(Report record);

    int updateByPrimaryKey(Report record);

    List<Report> getReportList();
}