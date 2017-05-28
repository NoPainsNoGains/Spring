package com.uestc.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanPostPrcessorImpl implements BeanPostProcessor{
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
	    System.out.println("对象" + beanName + "实例化之后");
		return bean;
	}
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		 System.out.println("对象" + beanName + "实例化之前");
		return bean;
	}
}
