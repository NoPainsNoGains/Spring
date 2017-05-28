package com.uestc.test;

import org.springframework.aop.framework.ProxyFactory;

public class HelloWorldWeaver {
    public static void main(String[] args) {
        MessageWriter target = new MessageWriter();
        ProxyFactory pf = new ProxyFactory(); //创建代理工厂
        pf.addAdvice(new MessageDecorator());//创建通知消息内容
        pf.setTarget(target);//通知目标对象     
        MessageWriter proxy = (MessageWriter) pf.getProxy();  //获得代理工厂的一个代理
        proxy.writeMessage();
    }
}
