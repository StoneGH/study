package org.study.java.designpattern.create.factory.abstractfactory;

public class SendMailFactory implements Provider {

	@Override
	public Sender produce() {
		return new MailSender();
	}

}
