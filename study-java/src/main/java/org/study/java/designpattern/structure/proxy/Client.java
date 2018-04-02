package org.study.java.designpattern.structure.proxy;

public class Client {
    public static void main(String[] args) {
//        //静态代理测试
//        Proxy proxy = new Proxy(new RealSubject());
//        proxy.operate();
//
//        //Java动态代理测试
//        DynimicProxyTest dynimicProxy = new DynimicProxyTest(new RealSubject());
//        ClassLoader classLoader = dynimicProxy.getClass().getClassLoader();
//        Subject subject = (Subject) java.lang.reflect.Proxy.newProxyInstance(classLoader, new Class[]{Subject.class}, dynimicProxy);
//        subject.operate();
//
//        //Cglib动态代理测试
//        CglibProxy cglibProxy = new CglibProxy();
//        RealSubject realSubject = (RealSubject) cglibProxy.getProxy(RealSubject.class);
//        realSubject.operate();
    }
}
