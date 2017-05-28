package com.uestc.test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class LoggingBeanDemo {
    public static void main(String[] args) {
        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("/applicationContext.xml"));
        LoggingBean lb = (LoggingBean)factory.getBean("logging");// logging
        lb.run();
    }
}