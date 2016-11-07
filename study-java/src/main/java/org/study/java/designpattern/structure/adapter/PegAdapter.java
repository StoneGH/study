package org.study.java.designpattern.structure.adapter;

public class PegAdapter implements IRoundPeg, ISquarePeg {
	private RoundPeg roundPeg;
	private SquarePeg squarePeg;

	public PegAdapter(RoundPeg roundPeg) {
		this.roundPeg = roundPeg;
	}

	public PegAdapter(SquarePeg squarePeg) {
		this.squarePeg = squarePeg;
	}

	@Override
	public void insert(String str) {
		this.squarePeg.insert(str);
	}

	@Override
	public void insertIntoHole(String msg) {
		this.roundPeg.insertIntoHole(msg);
	}

}
