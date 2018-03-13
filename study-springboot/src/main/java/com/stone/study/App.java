package com.stone.study;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 */
//@RestController//创建Rest服务
//@EnableAutoConfiguration//自动配置
@SpringBootApplication
@EnableTransactionManagement//装配事务支持
public class App extends SpringBootServletInitializer {

    /**
     * 自定义事务管理器
     *
     * @param dataSource
     * @return
     */
    @Bean
    public PlatformTransactionManager txManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 配置SpringMVC框架<br/>
     * 1、继承SpringBootServletInitializer<br/>
     * 2、重写configure方法
     *
     * @param builder
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(App.class);
    }

    @RequestMapping("/")
    public String index() {
        return "你好！SpringBoot。";
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
