package com.webstore.controllers;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import com.webstore.domain.Login;
import com.webstore.domain.User;
import com.webstore.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("here");
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new Login());
		return mav;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("login") Login login) {
		ModelAndView mav = null;
		User user = userService.validateUser(login);
		System.out.println("user found");
		if (null != user) {
			mav = new ModelAndView("welcome");
			mav.addObject("firstname", user.getFirstname());
		} else {
			mav = new ModelAndView("login");
			mav.addObject("message", "Your Username and Password is invalid !!");
		}
		return mav;
	}
	
	@RequestMapping(value = "/login?error", method = RequestMethod.GET)
	
	public ModelAndView errorLogin(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("error here");
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new Login());
		return mav;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("/logout");
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new Login());
		return mav;
	}
}