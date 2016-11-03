package org.study.java.designpattern.create.factory.abstractfactory;

public class SmsSender implements Sender {

	@Override
	public void send() {
		System.out.println("send sms……");
	}

}
