package com.stone.ssm.service.impl;

import org.springframework.stereotype.Service;

import com.stone.ssm.service.TestService;

@Service
public class TestServiceImpl implements TestService {
	@Override
	public void testMethod() {
		System.out.println("测试接口");
	}

}
