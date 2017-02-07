package com.stone.study.spring.aop.customer;

public class DefaultYiibaicutAdvisor {
	private DefaultYiibaicutAdvisor pointcut;
	private HiJackBeforeMethod advice;

	public DefaultYiibaicutAdvisor getPointcut() {
		return pointcut;
	}

	public void setPointcut(DefaultYiibaicutAdvisor pointcut) {
		this.pointcut = pointcut;
	}

	public HiJackBeforeMethod getAdvice() {
		return advice;
	}

	public void setAdvice(HiJackBeforeMethod advice) {
		this.advice = advice;
	}

}
