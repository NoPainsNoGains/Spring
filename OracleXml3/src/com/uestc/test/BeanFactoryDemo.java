package com.uestc.test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.uestc.dao.Oracle;

public class BeanFactoryDemo {
	public static void main(String[] args) {
		 XmlBeanFactory bf = new XmlBeanFactory(new ClassPathResource("/applicationContext.xml"));
		 
		 Oracle oracle = (Oracle) bf.getBean("oracle");
		 System.out.println("Meaning of life is " + oracle.defineMeaningOflife());
	}

}
