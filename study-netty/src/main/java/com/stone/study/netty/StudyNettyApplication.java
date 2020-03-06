package com.stone.study.netty;

import com.stone.study.netty.server.NettyServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudyNettyApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyNettyApplication.class, args);
        try {
            new NettyServer(8084).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
