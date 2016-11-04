package org.study.java.designpattern.structure.facade;

public class RunTest {
	public static void main(String[] args) {
		CarFacade facade = new CarFacade();
		facade.runCar(new Car());
	}
}
