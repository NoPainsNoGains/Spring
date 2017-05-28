package com.uestc.test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class InjectCollections {
		private Map map;
	    private Properties props;
	    private Set set;
	    private List list;
		public Map getMap() {
			return map;
		}
		public void setMap(Map map) {
			this.map = map;
		}
		public Properties getProps() {
			return props;
		}
		public void setProps(Properties props) {
			this.props = props;
		}
		public Set getSet() {
			return set;
		}
		public void setSet(Set set) {
			this.set = set;
		}
		public List getList() {
			return list;
		}
		public void setList(List list) {
			this.list = list;
		}
		 public void displayInfo() {
			// display the Map
			Iterator i = map.keySet().iterator();
			while (i.hasNext()) {
				Object key = i.next();
				System.out.println("Key: " + key + " - Value: " + map.get(key));
			}
	
			// display the properties
			i = props.keySet().iterator();
			System.out.println("\nProperties contents:\n");
			while (i.hasNext()) {
				String key = i.next().toString();
				System.out.println("Key: " + key + " - Value: "
						+ props.getProperty(key));
			}
			// display the set
			i = set.iterator();
			System.out.println("\nSet contents:\n");
			while (i.hasNext()) {
				System.out.println("Value: " + i.next());
			}
			
			// display the list
			i = list.iterator();
			System.out.println("\nList contents:\n");
			while (i.hasNext()) {
				System.out.println("Value: " + i.next());
			}
		}
		public static void main(String[] args) {
	        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("/applicationContext.xml"));
	        InjectCollections instance = (InjectCollections)factory.getBean("collectionsDemo");
	        instance.displayInfo();
	    }
}
