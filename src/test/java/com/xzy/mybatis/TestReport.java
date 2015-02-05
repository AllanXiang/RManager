package com.xzy.mybatis;

import com.alibaba.fastjson.JSON;
import com.xzy.model.Report;
import com.xzy.service.ReportService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class TestReport {
    private static Logger logger = Logger.getLogger(TestReport.class);
    //	private ApplicationContext ac = null;
    @Resource
    private ReportService reportService = null;


    @Test
    public void test1() {
//        Report r = this.reportService.calReport();
//        reportService.addReport();
    }
}
