package com.study.dubbo.service.impl;

import com.study.dubbo.service.DemoService;

public class DemoServiceImpl implements DemoService {

	public String sayHello(String name) {
		return "Hello " + name;
	}
}
