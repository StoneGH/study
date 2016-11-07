package org.study.java.designpattern.structure.composite;

import java.util.Iterator;

public abstract class Equipment {
	private String name;

	public abstract double netPrice();

	public abstract double discountPrice();

	public boolean add(Equipment equipment) {
		return false;
	}

	public boolean remove(Equipment equipment) {
		return false;
	}

	public Iterator iterator() {
		return null;
	}

	public Equipment(final String name) {
		this.name = name;
	}
}
