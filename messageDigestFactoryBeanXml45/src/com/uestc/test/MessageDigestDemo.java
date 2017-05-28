package com.uestc.test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.security.MessageDigest;
public class MessageDigestDemo {

    public static void main(String[] args) {
        XmlBeanFactory factory = new XmlBeanFactory(
                new ClassPathResource("/applicationContext.xml")
        );
        MessageDigest d1 = (MessageDigest)factory.getBean("sha");
        MessageDigest d2 = (MessageDigest)factory.getBean("md5");
        /*加密*/
        calculateDigest("Hello, world", d1);
        calculateDigest("Hello, world", d2);
    }

    private static void calculateDigest(String message, MessageDigest digest) {
        System.out.print("Digest using " + digest.getAlgorithm() + ": ");
        digest.reset();
        final byte[] bytes = digest.digest(message.getBytes());
        for (byte b : bytes) {
            System.out.print(String.format("%02x", b));//16进制查看文件
        }
        System.out.println("");
    }

}
