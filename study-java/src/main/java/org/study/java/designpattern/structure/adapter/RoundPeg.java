package org.study.java.designpattern.structure.adapter;

public class RoundPeg implements IRoundPeg {

	@Override
	public void insertIntoHole(String msg) {
		System.out.println("RoundPeg insert():" + msg);
	}

}
