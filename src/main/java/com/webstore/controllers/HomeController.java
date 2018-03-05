package com.webstore.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.webstore.domain.Greeting;
import com.webstore.domain.TestBean;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("inside home method of home controller");
		ModelAndView mav = new ModelAndView("home");
		return mav;
	}
	
	@RequestMapping(value = "/privatePage", method = RequestMethod.GET)
	public ModelAndView privatePage(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("inside home method of home controller");
		ModelAndView mav = new ModelAndView("privatePage");
		return mav;
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("home");
		
		// All the beans with scope mentioned as singleton will be loaded if lazy init
		// is not given as true.
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		Greeting greetingBean = (Greeting) context.getBean("greeter");
		System.out.println(greetingBean.getGreeting());
		TestBean obj = (TestBean) context.getBean("testBean");
		System.out.println("inside /home method of home controller" + obj.getMessage());
		((ConfigurableApplicationContext) (context)).close();
		
		return mav;
	}
	
}