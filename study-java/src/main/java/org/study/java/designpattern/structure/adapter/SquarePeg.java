package org.study.java.designpattern.structure.adapter;

public class SquarePeg implements ISquarePeg {

	@Override
	public void insert(String str) {
		System.out.println("Square insert():" + str);
	}

}
