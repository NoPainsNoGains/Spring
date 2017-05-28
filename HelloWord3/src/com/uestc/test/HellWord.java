package com.uestc.test;

import com.uestc.dao.MessageDestination;
import com.uestc.dao.MessageSource;
import com.uestc.dao.impl.SimpleMessageSource;
import com.uestc.dao.impl.StdoutMessageDestination;
import com.uestc.util.BeanFactory;

public class HellWord {
	public static void main(String[] args) {
		BeanFactory bf = new BeanFactory("/helloworld-context.properties");
		MessageSource source = (MessageSource)bf.getBean("source");
		MessageDestination destination = (MessageDestination)bf.getBean("destination");
		destination.write(source.getMessage());
	}
}
