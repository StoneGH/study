package org.study.java.designpattern.create.builder;

public class Director {
	private Builder builder;

	public Director(Builder builder) {
	}

	public void construct() {
		builder.buildPartA();
		builder.buildPartB();
		builder.buildPartC();
	}
}
