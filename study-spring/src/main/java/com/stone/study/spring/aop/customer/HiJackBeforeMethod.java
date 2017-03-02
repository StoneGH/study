package com.stone.study.spring.aop.customer;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

public class HiJackBeforeMethod implements MethodBeforeAdvice, AfterReturningAdvice, ThrowsAdvice, MethodInterceptor {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		// System.out.println("HiJackBeforeMethod:Before method hijackbeforemethod!");
	}

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		// System.out.println("HiJackBeforeMethod:After method hijackbeforemethod!");
	}

	public void afterThrowing(IllegalArgumentException e) throws Throwable {
		// System.out.println("HijackThrowException : Throw exception hijacked!");
	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("Method name:" + invocation.getMethod().getName());
		System.out.println("Method agrument:" + Arrays.toString(invocation.getArguments()));
		System.out.println("HiJackAroundMethod:Before method hijacked!");
		try {
			Object result = invocation.proceed();
			System.out.println("HiJackAroundMethod:Before after hijacked!");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("HiJackAroundMethod:Throw exception hijacked!");
			throw e;
		}
	}
}
