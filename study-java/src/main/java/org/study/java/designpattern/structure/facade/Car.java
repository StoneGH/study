package org.study.java.designpattern.structure.facade;

public class Car {
	public void start() {
		System.out.println("车子已启动。");
	}

	public void check_stop() {
		System.out.println("刹车检查。");
	}

	public void check_console() {
		System.out.println("检查仪表盘。");
	}
}
