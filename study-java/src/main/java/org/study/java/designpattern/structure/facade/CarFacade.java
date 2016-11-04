package org.study.java.designpattern.structure.facade;

public class CarFacade {
	public void runCar(Car car) {
		car.check_console();
		car.check_stop();
		car.start();
	}
}
