package com.uestc.test;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class BeanPostPrcessorDemo {
	public static void main(String[] args) {
		 /* BeanFactory实现BeanPostPrcessor
		  * ConfigurableListableBeanFactory factory = new XmlBeanFactory(
	                new ClassPathResource("/applicationContext.xml")
	        );
		  BeanPostProcessor bpp = (BeanPostProcessor)factory.getBean("beanPostPrcessorImpl");
		  factory.addBeanPostProcessor(bpp);
		  factory.getBean("people");*/
		
		 /* ApplicationContext实现BeanPostPrcessor;*/
		  ApplicationContext factory = new ClassPathXmlApplicationContext("/applicationContext.xml");
		  factory.getBean("people");
	}

}
