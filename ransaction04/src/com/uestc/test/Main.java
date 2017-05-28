package com.uestc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.uestc.dao.BankDao;
import com.uestc.service.BankService;


public class Main {

	public static void main(String[] args) {
		  ApplicationContext ac = new ClassPathXmlApplicationContext(
	                new String[] {
	                        "/applicationContext.xml"
	                }
	        );
		  /* 使用事务注解
		   * 注意datasource的注入 防止和jdbcSupport重写
		   *  */
		  BankService bankServiceImpl = (BankService) ac.getBean("bankServiceImpl");
	  	  bankServiceImpl.saveService();
	}

}
