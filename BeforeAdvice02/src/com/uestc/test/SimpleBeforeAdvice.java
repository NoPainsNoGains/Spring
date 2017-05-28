package com.uestc.test;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class SimpleBeforeAdvice implements MethodBeforeAdvice{
	@Override
	public void before(Method method, Object[] arg1, Object arg2)
			throws Throwable {
		System.out.println(method.getName()+"方法调用之前");
	}
	 public static void main(String[] args) {
		 MessageWriter target = new MessageWriter();//被通知对象		 
		 //创建代理
		 ProxyFactory pf = new ProxyFactory();
		 pf.addAdvice(new SimpleBeforeAdvice());
		 pf.setTarget(target);	 
		 //通过代理工厂获取封装后的代理对象
		 MessageWriter messageWriter = (MessageWriter)pf.getProxy();
		 messageWriter.writeMessage();	 
	 }
}
