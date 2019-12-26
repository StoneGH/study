package com.stone.study.springcloud.consumer.service.impl;

import com.stone.study.springcloud.consumer.service.ServerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerClientImpl {

    @Autowired
    private ServerClient serverClient;

    public String say() {
        return serverClient.hello("cloud");
    }
}
