package com.uestc.test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;


public class main {
	public static void main(String[] args) {
			XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("/applicationContext.xml"));
			Target byNameBean = (Target)factory.getBean("byName");
			System.out.println(byNameBean.toString()+"\n\n");
			
			Target byTypeBean = (Target)factory.getBean("byType");
			System.out.println(byTypeBean.toString()+"\n\n");
			
			Target constructorBean = (Target)factory.getBean("constructor");
			System.out.println(constructorBean.toString()+"\n\n");
			
			Target autodetectBean = (Target)factory.getBean("autodetect");
			System.out.println(autodetectBean.toString()+"\n\n");
	}
}
