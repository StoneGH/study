package org.study.java.designpattern.create.singleton;

public class Singleton {
	private Singleton() {

	}

	private static Singleton instance = new Singleton();

	public static Singleton getInstance() {
		return instance;
	}
}
