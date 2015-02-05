package com.xzy.mybatis;

import com.alibaba.fastjson.JSON;
import com.xzy.model.SearchLog;
import com.xzy.model.Statistics.Statistics;
import com.xzy.service.SearchLogService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class TestLog {
    private static Logger logger = Logger.getLogger(TestLog.class);
    //	private ApplicationContext ac = null;
    @Resource
    private SearchLogService searchLogService = null;

//	@Before
//	public void before() {
//		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		userService = (IUserService) ac.getBean("userService");
//	}

    @Test
    public void test1() {
//        logger.info(serverService.addServer(ser));
//        Statistics list = searchLogService.getProvinceStatistics("2014-12-12", "182.92.221.159");
//        for(SearchLog searchlog: list){
//            System.out.println(searchlog.getProvince());
//        }
//        logger.info(JSON.toJSONString(list));
    }
}
