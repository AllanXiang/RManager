package com.xzy.mybatis;

import com.alibaba.fastjson.JSON;
import com.xzy.model.User;
import com.xzy.service.QueryService;
import com.xzy.service.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class TestMyBatis {
    private static Logger logger = Logger.getLogger(TestMyBatis.class);
    //	private ApplicationContext ac = null;
    @Resource
    private QueryService queryService = null;


    @Test
    public void test1() {
//        logger.info(JSON.toJSON(queryService.getBatchList()));
    }
}
