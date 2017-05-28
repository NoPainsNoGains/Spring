package com.uestc.test;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MessageDecorator implements MethodInterceptor{
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.print("Hello ");
        Object retVal = invocation.proceed();//目标方法
        System.out.println("!");
        return retVal;
	}
}
