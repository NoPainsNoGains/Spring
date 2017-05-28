package com.uestc.test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedInputStream;
import java.io.IOException;
public class initBeanDemo {

    public static void main(String[] args) throws IOException {
        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("/applicationContext.xml"));
        System.out.println(factory.getBean("simple3").toString()); 
    }

}
