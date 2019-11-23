package com.grasim.IndogulfAPI.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class PathLoader implements BeanFactoryPostProcessor  {

	private String path = "";

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		PathLoader loader = (PathLoader) beanFactory.getBean("pathLoader");
		loader.path = "file:C:\\Users\\SARABJEET\\Desktop\\application.properties";
		System.out.println("before init------------=======-----------------------------");
	}

}
