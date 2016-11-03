package org.study.java.designpattern.create.factory.abstractfactory;

public class SendSmsFactory implements Provider {

	@Override
	public Sender produce() {
		return new SmsSender();
	}

}
