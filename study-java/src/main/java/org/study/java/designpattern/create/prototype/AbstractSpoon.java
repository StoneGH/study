package org.study.java.designpattern.create.prototype;

public abstract class AbstractSpoon implements Cloneable {
	String spoonName;

	public String getSpoonName() {
		return spoonName;
	}

	public void setSpoonName(String spoonName) {
		this.spoonName = spoonName;
	}

	@Override
	protected Object clone() {
		Object object = null;
		try {
			object = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			System.err.println("AbstractSpoon is not Cloneable");
		}
		return object;
	}

}
