package com.webstore.domain;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class TestBean implements InitializingBean, DisposableBean {
	
	private String message;
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	// Same as init method!! called after dependency injection  of the bean.
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("going through afterProperties set in TestBean.java");
		
	}
	
	// Same as destroy method!!
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("destroy in testbean.java");
		
	}
	
	/*
	 * @PostConstruct This method will be called just after the bean is instantiated
	 * by spring
	 * 
	 * public void init() {
	 * System.out.println("this method is called just after initialization "); }
	 * 
	 * 
	 * @PreDestroy This method will be called just before the bean is being
	 * destroyed
	 * 
	 * public void destroy() { System.out.println("this method destroy"); }
	 */
}
