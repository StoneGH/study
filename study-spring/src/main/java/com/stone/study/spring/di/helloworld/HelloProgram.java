package com.stone.study.spring.di.helloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloProgram {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		HelloWorldService helloWorldService = (HelloWorldService) context.getBean("helloWorldService");
		helloWorldService.getHelloWorld().sayHello();
	}
}
