package com.uestc.test;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class PeopleDemo {

    public static void main(String[] args) {
        ConfigurableListableBeanFactory factory = new XmlBeanFactory(
                new ClassPathResource("/applicationContext.xml")
        );
        BeanPostProcessor bfpp = (BeanPostProcessor)factory.getBean("bfpp");
        factory.addBeanPostProcessor(bfpp);
        People people = (People)factory.getBean("people");
        factory.destroySingletons();
    }
}
