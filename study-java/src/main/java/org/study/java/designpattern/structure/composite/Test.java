package org.study.java.designpattern.structure.composite;

public class Test {
	public static void main(String[] args) {
		Cabinet cabinet = new Cabinet("Tower");
		Chassis chassis = new Chassis("PC Chassis");
		cabinet.add(chassis);
		chassis.add(new Disk("10 GB"));
		System.out.println("netPrice=" + cabinet.netPrice());
		System.out.println("discountPrice=" + cabinet.discountPrice());
	}
}
