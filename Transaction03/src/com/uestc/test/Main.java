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
		  /*声明式事务管理 
			    第一种 每个Bean都有一个代理 applicationContext01.xml
			  BankService bankServiceTransaction = (BankService) ac.getBean("bankServiceTransaction");
			  bankServiceTransaction.saveService();
		  */
		  /*所有Bean共享一个代理基类 applicationContext02.xml
			  BankService transactionProxy = (BankService) ac.getBean("transactionProxy");
			  transactionProxy.saveService();
		  */
		  /*事务拦截器 applicationContext03.xml
		  	  BankService bankServiceImpl = (BankService) ac.getBean("bankServiceImpl");  直接用bankServiceImpl 
		  	  bankServiceImpl.saveService();
		  */
		  /* 使用tx标签配置的拦截器    applicationContext04.xml 
			  BankService bankServiceImpl = (BankService) ac.getBean("bankServiceImpl");  直接用bankServiceImpl 
		  	  bankServiceImpl.saveService();
	  	  */
	}

}
