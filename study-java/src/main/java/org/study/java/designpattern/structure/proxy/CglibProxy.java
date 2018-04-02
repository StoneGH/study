package org.study.java.designpattern.structure.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by shitao on 2018/3/15.
 */
public class CglibProxy implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz) {
        enhancer.setSuperclass(clazz);//设置需要创建子类的类
        enhancer.setCallback(this);
        return enhancer.create();//通过字节码技术动态创建子类实例
    }

    /**
     * 拦截父类所有的方法调用
     *
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("after");
        return result;
    }
}
