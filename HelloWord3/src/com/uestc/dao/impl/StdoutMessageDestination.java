package com.uestc.dao.impl;

import java.io.PrintStream;

import com.uestc.dao.MessageDestination;

public class StdoutMessageDestination implements MessageDestination{

	@Override
	public void write(String message) {
		System.out.println("输出: "+message);
		
	}


}
