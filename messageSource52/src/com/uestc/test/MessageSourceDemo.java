package com.uestc.test;

import java.util.Locale;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class MessageSourceDemo {
	public static void main(String[] args) {
		  ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
		    
		    Locale en = Locale.ENGLISH;
	      

	        System.out.println(ctx.getMessage("msg", null, en));
	        
	        System.out.println(ctx.getMessage("msg", null, Locale.UK));
	        
	        System.out.println(ctx.getMessage("hello", null, Locale.UK));

	        System.out.println(ctx.getMessage("nameMsg",new Object[] { "Jan", "Machacek" }, en));
	}
}
