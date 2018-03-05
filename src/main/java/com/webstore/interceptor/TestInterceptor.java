package com.webstore.interceptor;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/* If this method returns true then only the request is transferred to the controller for further processing  
 * and if it returns false then the request is transferred to the webpage directly.
 * */
public class TestInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		System.out.println("this preHandle method of TestInterceptor is called !!!! ");
		Calendar cal = Calendar.getInstance();
		int dayOfWeek = cal.get(cal.DAY_OF_WEEK);
		
		if (dayOfWeek == 1) {
			response.getWriter().write("Website is down on Sundays");
			// response.sendRedirect(request.getContextPath() + "/" + "market/products");
			return false;
		}
		
		return true;
	}
	
	/*
	 * This method will be called after the Spring MVC ececutes request handler for
	 * the request
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
		System.out.println("post handle of TestInterceptor is called");
	}
	
	/*
	 * This method will be called after the response object has been produced by the
	 * view
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exceptionIfAny) {
		// NO operation.
		System.out.println("after completn of TestInterceptor is called");
	}
}
