package org.study.java.designpattern.structure.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CompositeEquipment extends Equipment {

	private int i = 0;

	private List equipment = new ArrayList();

	public CompositeEquipment(String name) {
		super(name);
	}

	@Override
	public boolean add(Equipment equipment) {
		this.equipment.add(equipment);
		return true;
	}

	@Override
	public double netPrice() {
		double netPrice = 0.;
		Iterator iterator = equipment.iterator();
		while (iterator.hasNext()) {
			netPrice += ((Equipment) iterator.next()).netPrice();
		}
		return netPrice;
	}

	@Override
	public double discountPrice() {
		double discountPrice = 0;
		Iterator iterator = equipment.iterator();
		while (iterator.hasNext()) {
			discountPrice += ((Equipment) iterator.next()).discountPrice();
		}
		return discountPrice;
	}

	@Override
	public Iterator iterator() {
		return equipment.iterator();
	}

	public boolean hasNext() {
		return i < equipment.size();
	}

	public Object next() {
		if (hasNext()) {
			return equipment.get(i++);
		} else {
			throw new NoSuchElementException();
		}
	}
}
