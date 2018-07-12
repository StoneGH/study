package com.stone.study.springcloud.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() {
        List<ServiceInstance> instance = client.getInstances("hello");
        if (instance != null && instance.size() > 0) {
            LOGGER.info("/hello,host:" + instance.get(0).getUri() + ",service_id:" + instance.get(0).getServiceId());
        }
        return "Hello world!";
    }
}
