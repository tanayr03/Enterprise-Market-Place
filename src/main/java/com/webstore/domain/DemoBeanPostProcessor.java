package com.webstore.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class DemoBeanPostProcessor implements BeanPostProcessor, Ordered {
	
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		// called before init
		System.out.println("DemoBeanPostProcessor1 before init method is called");
		return bean;
	}
	
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		// called after init
		System.out.println("DemoBeanPostProcessor1 after init method is called");
		return bean;
	}
	
	public int getOrder() {
		// TODO Auto-generated method stub
		// Lower the order the first it wil get called
		return 2;
	}
	
}
