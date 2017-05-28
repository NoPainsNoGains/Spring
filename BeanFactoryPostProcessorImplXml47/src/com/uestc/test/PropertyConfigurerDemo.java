package com.uestc.test;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
public class PropertyConfigurerDemo {

    public static void main(String[] args) {
        ConfigurableListableBeanFactory beanFactory = new XmlBeanFactory(
                new ClassPathResource("/applicationContext.xml")
        );
        BeanFactoryPostProcessor bfpp = (BeanFactoryPostProcessor)beanFactory.getBean("bfpp");
        bfpp.postProcessBeanFactory(beanFactory);   
        System.out.println(beanFactory.getBean("simpleBean"));
    }
}
