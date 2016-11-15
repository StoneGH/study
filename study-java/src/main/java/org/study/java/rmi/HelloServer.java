package org.study.java.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class HelloServer {
	public static void main(String[] args) throws MalformedURLException, RemoteException, AlreadyBoundException {
		Hello hello = new HelloImpl();
		//注册通讯端口
		LocateRegistry.createRegistry(6600);
		Naming.bind("rmi://127.0.0.1:6600/Hello", hello);
		System.out.println("Service start!");
	}
}
