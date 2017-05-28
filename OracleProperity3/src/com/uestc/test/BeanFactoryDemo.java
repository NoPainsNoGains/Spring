package com.uestc.test;

import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import com.uestc.dao.Oracle;

public class BeanFactoryDemo {
	public static void main(String[] args) {
		 DefaultListableBeanFactory bf = new DefaultListableBeanFactory();
		 BeanDefinitionReader reader = new PropertiesBeanDefinitionReader(bf);
		 reader.loadBeanDefinitions(new ClassPathResource("/oracle.properties"));
		 
		 Oracle oracle = (Oracle) bf.getBean("oracle");
		 System.out.println("Meaning of life is " + oracle.defineMeaningOflife());
	}

}
