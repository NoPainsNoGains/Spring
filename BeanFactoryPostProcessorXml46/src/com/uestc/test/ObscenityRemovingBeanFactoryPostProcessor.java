package com.uestc.test;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.StringValueResolver;

public class ObscenityRemovingBeanFactoryPostProcessor implements BeanFactoryPostProcessor,BeanNameAware{
	private String name;
	private Set<String> obscenitiesRemoved;
	private Set<String> obscenities;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getObscenitiesRemoved() {
		return obscenitiesRemoved;
	}

	public void setObscenitiesRemoved(Set<String> obscenitiesRemoved) {
		this.obscenitiesRemoved = obscenitiesRemoved;
	}

	public Set<String> getObscenities() {
		return obscenities;
	}
	
	public void setObscenities(Set<String> obscenities) {
		this.obscenities.clear();
        for (String obscenity : obscenities) {
            this.obscenities.add(obscenity.toUpperCase());
        }
	}
	
	/*构造*/
	public ObscenityRemovingBeanFactoryPostProcessor() {
		this.obscenities =  new HashSet<String>();
		this.obscenitiesRemoved =  new HashSet<String>();
	}
	/*判断属性值是否在过滤器中*/
	private boolean isObscene(Object value) {
        String potentialObscenity = value.toString().toUpperCase();
        return this.obscenities.contains(potentialObscenity);
	}
	/*BeanFactoryPostProcessor核心方法
	 *  实现对bean配置信息读取、检测、过滤
	 * */
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
			throws BeansException {
		/*获取所有bean的名*/
		String[] beanNames = beanFactory.getBeanDefinitionNames();
		/*根据bean名 取出每个bean对象*/
		for (String beanName : beanNames) {
			if(beanNames.equals(this.name)) continue;//排除自身类 不检查
				
			BeanDefinition bd = beanFactory.getBeanDefinition(beanName);//BeanDefinition 包含所有创建bean所需信息的复杂对象
			 StringValueResolver valueResolver = new StringValueResolver() {//对指定字符串进行解析
				@Override
				public String resolveStringValue(String strVal) {
					if(isObscene(strVal)){
						obscenitiesRemoved.add(strVal);
						return "****";
					}
					return strVal;
				}	 
			 };
			 BeanDefinitionVisitor visitor = new BeanDefinitionVisitor(valueResolver);
	         visitor.visitBeanDefinition(bd);
		}
		beanFactory.registerSingleton("obscenitiesRemoved", this.obscenitiesRemoved);//代码进行bean注册 beanName beanValue
	}

	@Override
	public void setBeanName(String name) {
		this.name=name;
	}

}
