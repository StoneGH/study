package com.stone.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stone.ssm.service.TestService;

//指定bean注入的配置文件  
@ContextConfiguration(locations = {"classpath:config/spring/*.xml"})
// 使用标准的JUnit @RunWith注释来告诉JUnit使用Spring TestRunner
@RunWith(SpringJUnit4ClassRunner.class)
public class ServiceTest {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    TestService testService;

    @Test
    public void testMethodTest() {
        testService.testMethod();
    }
}
