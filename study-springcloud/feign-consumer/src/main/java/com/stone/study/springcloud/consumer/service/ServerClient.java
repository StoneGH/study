package com.stone.study.springcloud.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "SERVER")
public interface ServerClient {
    @RequestMapping(value = "hello")
    public String hello(@RequestParam("param") String param);
}
