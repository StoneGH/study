package org.study.java.designpattern.create.factory.factorymethod;

public class FactoryTest {
	public static void main(String[] args) {
		Sender sender = SendFactory.produceMail();
		sender.send();
	}
}
