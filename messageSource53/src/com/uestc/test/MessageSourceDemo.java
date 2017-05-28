package com.uestc.test;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageSourceDemo {
	public static void main(String[] args) {  
		  Locale en = Locale.ENGLISH;
		  Locale zh = Locale.CHINESE;
		  ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");    
         
		  String message1 = ctx.getMessage("message.user.username", null, en);  
          String message3 = ctx.getMessage("message.user.username", null, Locale.CHINESE);  
          String message4 = ctx.getMessage("message.user.context", new Object[]{"ycl"}, zh);  
        
          System.out.println(message1);  
          System.out.println(message3);  
          System.out.println(message4);  
   }  
}
