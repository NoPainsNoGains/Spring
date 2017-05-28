package com.uestc.test;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class People {
	private int age;
	private String name;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@PostConstruct
	public void init(){
		System.out.println("people初始化...");
	}
	@PreDestroy
	public void destory(){
		System.out.println("people销毁...");
	}
}
