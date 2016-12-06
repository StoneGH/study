package com.study.dubbox.service.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.study.dubbo.service.DemoService;

@Path("demo")
public class DemoServiceImpl implements DemoService {

	@GET
	@Path("hello")
	public String sayHello(@QueryParam("name") String name) {
		System.out.println("Hello " + name);
		return "Hello " + name;
	}
}