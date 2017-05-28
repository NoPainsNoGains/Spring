package com.uestc.test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;


public class main {
	public static void main(String[] args) {
			XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("/applicationContext.xml"));
			SimpleBean simpleBean = (SimpleBean)factory.getBean("target2");
			System.out.println(simpleBean.toString());
	}
}
