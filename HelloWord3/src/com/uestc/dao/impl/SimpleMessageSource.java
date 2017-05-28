package com.uestc.dao.impl;

import com.uestc.dao.MessageSource;

public class SimpleMessageSource implements MessageSource{
	private String message; 
	
	public SimpleMessageSource() {
		this.message = "Hello, world";
	}

	@Override
	public String getMessage() {
		return message;
	}

}
