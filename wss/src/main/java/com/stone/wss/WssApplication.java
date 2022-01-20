package com.stone.wss;

import com.stone.wss.config.NettyServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WssApplication {

    public static void main(String[] args) {
        SpringApplication.run(WssApplication.class, args);
        try {
            new NettyServer(8118).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
