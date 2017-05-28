package com.uestc.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {
	private Map<String,String> beanDefinitions;

	public Map<String, String> getBeanDefinitions() {
		return beanDefinitions;
	}
	public void setBeanDefinitions(Map<String, String> beanDefinitions) {
		this.beanDefinitions = beanDefinitions;
	}
	public BeanFactory(String beanDefintions) {
		readBeanDefinitopns(beanDefintions);
	}
	/*作用:从配置文件创建bean对象 
	 *    并存入到Map<string,string>类型的成员变量beanDefinitions中
	 * */
	private void readBeanDefinitopns(String beanDefinitionsSource){
			Properties props = new Properties();//配置文件
			InputStream is = BeanFactory.class.getResourceAsStream(beanDefinitionsSource);
			if(is==null){
				throw new IllegalArgumentException("Could not load properties file " + beanDefinitionsSource);
			}
			 try {
		            props.load(is);
		            is.close();
		            this.beanDefinitions = new HashMap<String, String>();
		            /*创建将配置文件Bean对象 并存入到Map<string,string>*/
		            for (Map.Entry<Object, Object> entry : props.entrySet()) {
		                this.beanDefinitions.put(entry.getKey().toString(), entry.getValue().toString());
		            }
		        } catch (IOException e) {
		            throw new RuntimeException("Could not read the properties file " + beanDefinitionsSource);
		        }
	}
	/*从Map<string,string>类型的私有属性中查找 用户所需要的bean*/
	public Object getBean(String name) {
        String className = this.beanDefinitions.get(name);//从map集合中获取用户需要对象
        if (className == null) return null;
        try {
            return Class.forName(className).newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Could not create bean " + name);
        }
    }
}
