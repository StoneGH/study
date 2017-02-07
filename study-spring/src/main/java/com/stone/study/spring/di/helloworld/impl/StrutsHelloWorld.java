package com.stone.study.spring.di.helloworld.impl;

import com.stone.study.spring.di.helloworld.HelloWorld;

public class StrutsHelloWorld implements HelloWorld{

	@Override
	public void sayHello() {
		System.out.println("Struts Say HelloWorld!!");
	}

}
