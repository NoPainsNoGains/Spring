package com.uestc.test;

import java.security.MessageDigest;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

public class MessageDigestFactoryBean implements  FactoryBean,InitializingBean{
	private static final String DEFAULT_ALGORITHM = "MD5";
	private String algorithm = DEFAULT_ALGORITHM;
    private MessageDigest messageDigest;
    
	public String getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}

	public MessageDigest getMessageDigest() {
		return messageDigest;
	}

	public void setMessageDigest(MessageDigest messageDigest) {
		this.messageDigest = messageDigest;
	}

	public static String getDefaultAlgorithm() {
		return DEFAULT_ALGORITHM;
	}
	/*返回代理对象*/
	@Override
	public Object getObject() throws Exception {
		return this.messageDigest.clone();
	}
	/*返回代理对象类型*/
	@Override
	public Class getObjectType() {
		return MessageDigest.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
	/*初始化回调中产生代理对象*/
	@Override
	public void afterPropertiesSet() throws Exception {
		this.messageDigest = MessageDigest.getInstance(algorithm);
	}

}
