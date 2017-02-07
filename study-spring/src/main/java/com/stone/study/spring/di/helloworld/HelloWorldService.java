package com.stone.study.spring.di.helloworld;

public class HelloWorldService {
	private HelloWorld helloWorld;

	public HelloWorldService() {
	}

	public HelloWorld getHelloWorld() {
		return helloWorld;
	}

	public void setHelloWorld(HelloWorld helloWorld) {
		this.helloWorld = helloWorld;
	}

}
