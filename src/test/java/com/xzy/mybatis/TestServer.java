package com.xzy.mybatis;

import com.alibaba.fastjson.JSON;
import com.xzy.model.Server;
import com.xzy.service.ServerService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class TestServer {
    private static Logger logger = Logger.getLogger(TestServer.class);
    //	private ApplicationContext ac = null;
    @Resource
    private ServerService serverService = null;

//	@Before
//	public void before() {
//		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		userService = (IUserService) ac.getBean("userService");
//	}

    @Test
    public void test1() {
        List<String> list = serverService.getServerIpList();
//        for(Server server: list){
//            System.out.println(server.getServerStime());
//        }
        logger.info(JSON.toJSONString(list));
    }
}
