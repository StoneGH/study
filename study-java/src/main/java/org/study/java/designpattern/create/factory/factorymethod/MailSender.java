package org.study.java.designpattern.create.factory.factorymethod;

public class MailSender implements Sender {

	@Override
	public void send() {
		System.out.println("send mail……");
	}

}
