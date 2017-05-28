package com.uestc.test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedInputStream;
import java.io.IOException;
public class DestructiveBeanDemo {

    public static void main(String[] args) throws IOException {
        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("/applicationContext.xml"));
        System.out.println(factory.getBean("destructive"));
        new BufferedInputStream(System.in).read();//从终端输入
        factory.destroySingletons();//触发spring的配置destory-method
        System.out.println("Almost done!");
    }
}
