package org.study.java.designpattern.create.factory.abstractfactory;

public class FactoryTest {
	public static void main(String[] args) {
		Provider provider = new SendMailFactory();
		Sender sender = provider.produce();
		sender.send();
	}
}
