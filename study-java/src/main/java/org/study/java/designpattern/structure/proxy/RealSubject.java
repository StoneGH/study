package org.study.java.designpattern.structure.proxy;

public class RealSubject implements Subject {

	@Override
	public void operate() {
		System.out.println("excute operate……");
	}

}
