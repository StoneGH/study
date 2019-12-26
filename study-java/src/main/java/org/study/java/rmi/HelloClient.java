package org.study.java.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;

public class HelloClient {
    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
        Hello hello = (Hello) Naming.lookup("rmi://127.0.0.1:6600/Hello");
        try {
            System.out.println(hello.sayHello("Stone"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Collections.sort(new ArrayList());

    }
}
