package com.uestc.dao.impl;

import com.uetsc.dao.Axe;
import com.uetsc.dao.Person;

public class Chinese implements Person{
	//面向Axe 接口编程，而不是具体的实现类
	private Axe axe;
	//默认的构造器
	public Chinese(){
	    System.out.println("Spring实例化主调bean: Chinese 实例... ");
	}
	//设值注入所需的setter 方法
	public void setAxe( Axe axe){
	    System.out.println(" Spring 执行依赖关系注入...");
	    this.axe = axe;
	}
	//实现Person 接口的useAxe 方法
	public void useAxe(){
	    System.out.println(axe.chop());
	}
}
