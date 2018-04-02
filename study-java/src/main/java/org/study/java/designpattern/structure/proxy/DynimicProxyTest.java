package org.study.java.designpattern.structure.proxy;

import java.lang.reflect.*;

/**
 * 动态代理
 */
public class DynimicProxyTest {
    public static void main(String[] args) {
        InvocationHandler handler = new RealObjImpl();
        IRealObj realObj = (IRealObj) java.lang.reflect.Proxy.newProxyInstance(IRealObj.class.getClassLoader(), new Class[]{IRealObj.class}, handler);
        realObj.m1();
    }


}


interface IRealObj {
    void m1();
}

class RealObjImpl implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK 动态代理执行");
        System.out.println("动态代理实现");
        return null;
    }
}
