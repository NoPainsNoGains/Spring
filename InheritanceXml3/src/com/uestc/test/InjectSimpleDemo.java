package com.uestc.test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
public class InjectSimpleDemo {
    private String name;
    private int age;
    private float height;
    private boolean isProgrammer;
    private Long ageInSeconds;

    public static void main(String[] args) {
       
        XmlBeanFactory parent = new XmlBeanFactory(new ClassPathResource("/parent-context.xml"));
        InjectSimpleDemo simple1 = (InjectSimpleDemo)parent.getBean("injectSimpleDemo");
        System.out.println(simple1);
       
        XmlBeanFactory son = new XmlBeanFactory(new ClassPathResource("/son-context.xml"),parent); /*配置工厂的父子关系 子工厂可以引用父工厂bean*/
        InjectSimpleDemo simple2 = (InjectSimpleDemo)son.getBean("injectSimpleParent");
        System.out.println(simple2);
    }

    public void setAgeInSeconds(Long ageInSeconds) {
        this.ageInSeconds = ageInSeconds;
    }

    public void setIsProgrammer(boolean isProgrammer) {
        this.isProgrammer = isProgrammer;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nAge: %d\nAge in Seconds: %d\nHeight: %g\nIs Programmer?: %b",
                this.name, this.age, this.ageInSeconds, this.height, this.isProgrammer);
    }
}
 