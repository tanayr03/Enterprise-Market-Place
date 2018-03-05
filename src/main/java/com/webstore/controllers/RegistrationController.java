package com.webstore.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.webstore.beanvalidator.UserValidator;
import com.webstore.domain.User;
import com.webstore.service.UserService;

@Controller
@EnableWebMvc

public class RegistrationController {
	
	@Autowired
	public UserService userService;
	
	@Autowired
	UserValidator userValidator;
	
	@InitBinder
	public void initialisetheBinder(WebDataBinder binder) {
		binder.setAllowedFields("username", "password", "email", "firstname", "lastname", "phone");
		binder.setValidator(userValidator);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("register");
		User user = new User();
		mav.addObject("user", user);
		return mav;
	}
	
	// Here the @Valid annotation will check for size attribute mentioned in the
	// user bean
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response, @Valid @ModelAttribute("user") User user, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			System.out.println("has errors");
			mav.setViewName("register");
			return mav;
		}
		System.out.println("success");
		// userService.register(user);
		mav.addObject("username", user.getUsername());
		mav.setViewName("registrationSuccess");
		return mav;
	}
	
}