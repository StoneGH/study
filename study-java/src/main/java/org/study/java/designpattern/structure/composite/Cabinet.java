package org.study.java.designpattern.structure.composite;

public class Cabinet extends CompositeEquipment {

	public Cabinet(String name) {
		super(name);
	}

	@Override
	public double netPrice() {
		return 1.0 + super.netPrice();
	}

	@Override
	public double discountPrice() {
		return 0.5 + super.discountPrice();
	}

}
