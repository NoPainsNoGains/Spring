package com.uestc.dao.impl;

import com.uetsc.dao.Axe;

public class SteelAxe implements Axe{
	//count是个状态值，每次执行chop 方法该值增加1
	private int count = 0;
	public SteelAxe(){
	    System.out.println("Spring实例化依赖bean: SteelAxe 实例.. .");
	}
	//测试用方法
	public String chop(){
	    return "钢斧砍柴真快" + ++count;
	}
}
