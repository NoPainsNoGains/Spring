package com.uestc.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanNameAware;

public class LoggingBean implements BeanNameAware{
	private static final Log logger = LogFactory.getLog(LoggingBean.class);//InjectCollections
	private String name;
	@Override
	public void setBeanName(String name) {
		this.name = name;
	}
	
	public void run() {
        if (logger.isInfoEnabled()) {
            logger.info("Bean name is'" + this.name + "'.");
        }
    }
}
