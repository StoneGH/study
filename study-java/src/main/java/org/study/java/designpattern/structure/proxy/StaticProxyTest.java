package org.study.java.designpattern.structure.proxy;

/**
 * 静态代理
 * Created by shitao on 2018/3/23.
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        IRealObject proxy = new StaticProxy(new RealObject());
        proxy.m1();
    }
}

/**
 * 抽象角色
 */
interface IRealObject {
    void m1();
}


class RealObject implements IRealObject {

    @Override
    public void m1() {
        System.out.println("This is m1() method");
    }
}


class StaticProxy implements IRealObject {
    private IRealObject realObject;

    public StaticProxy(IRealObject realObject) {
        this.realObject = realObject;
    }

    @Override
    public void m1() {
        System.out.println("静态代理执行");
        realObject.m1();
    }
}