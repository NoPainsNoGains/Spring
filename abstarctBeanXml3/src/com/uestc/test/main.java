package com.uestc.test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.uestc.dao.impl.Chinese;


public class main {
	public static void main(String[] args) {
			XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("/applicationContext.xml"));
			SimpleBean simpleBean1 = (SimpleBean)factory.getBean("bean1");
			System.out.println(simpleBean1.toString()+"\n\n");
			
			SimpleBean simpleBean2 = (SimpleBean)factory.getBean("bean2");
			System.out.println(simpleBean2.toString());
	}
}
