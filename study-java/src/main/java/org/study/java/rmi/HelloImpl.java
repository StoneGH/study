package org.study.java.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements Hello {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8296745055565902334L;

	protected HelloImpl() throws RemoteException {
		super();
	}

	@Override
	public String sayHello(String name) throws RemoteException {
		return "Hello," + name;
	}

}
