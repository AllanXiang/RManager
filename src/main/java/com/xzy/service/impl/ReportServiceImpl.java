package com.xzy.service.impl;

import com.alibaba.fastjson.JSON;
import com.xzy.dao.ManualLogMapper;
import com.xzy.dao.ReportMapper;
import com.xzy.dao.SearchLogMapper;
import com.xzy.model.Report;
import com.xzy.model.SearchLog;
import com.xzy.service.ReportService;
import com.xzy.util.Time;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by xzy on 2015-01-19 4:04 PM.
 */
@Service("reportService")
public class ReportServiceImpl implements ReportService {

    private static Logger logger = Logger.getLogger(ReportServiceImpl.class);
    DecimalFormat df = new DecimalFormat("0.00%");

    @Resource
    private ReportMapper reportMapper;
    @Resource
    private ManualLogMapper manualLogMapper;
    @Resource
    private SearchLogMapper searchLogMapper;

    @Override
    public void addReport() {
        String time = Time.getPrevMonth(new Date());
        logger.info(time+"---start add report");
        Report report = calReport(time);
//        System.out.println(JSON.toJSON(report));
        logger.info(reportMapper.insertSelective(report));
        logger.info(time+"---end add report");
    }

    public Report calReport(String time){
        List<SearchLog> logs = this.searchLogMapper.getSearchLogMonthList(time);
        int ok = 0;
        int err = 0;
        float spendtime = 0;
        for(SearchLog log: logs){
            int condition = log.getSearchcondition();
            if(condition==1 || condition==2 || condition==4){
                ok += 1;
            }else{
                err += 1;
            }
            spendtime += log.getSpendtime();
        }
        int man = this.manualLogMapper.getManualLogNum(time);
        int tot = man+ok+err;
        float avg = spendtime;
        if(logs.size()!=0){
            avg = avg/logs.size();
        }
        float rate = (float)ok;
        if(tot==0){
            rate = 0;
        }else{
            rate /= tot;
        }
        Report report = new Report();
        report.setReportTime(time.substring(0, 7));
        report.setReportOkNum(ok);
        report.setReportTotNum(tot);
        report.setReportErrorNum(err);
        report.setReportAvgTime(avg);
        report.setReportManualNum(man);
        report.setReportRate(df.format(rate));
        return report;
    }

    @Override
    public List<Report> getReportList() {
        List<Report> reports = this.reportMapper.getReportList();
        Report r = calReport(Time.dateToStringDateMonthBegin(new Date()));
        reports.add(r);
        return reports;
    }
}
