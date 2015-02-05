package com.xzy.service;

import com.xzy.model.Report;

import java.util.List;

/**
 * Created by xzy on 2015-01-19 1:25 PM.
 */
public interface ReportService {
    public void addReport();
    public List<Report> getReportList();
}
