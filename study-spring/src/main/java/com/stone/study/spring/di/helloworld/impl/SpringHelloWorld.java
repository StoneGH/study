package com.stone.study.spring.di.helloworld.impl;

import com.stone.study.spring.di.helloworld.HelloWorld;

public class SpringHelloWorld implements HelloWorld {
	@Override
	public void sayHello() {
		System.out.println("Spring Say Hello!!");
	}
}
