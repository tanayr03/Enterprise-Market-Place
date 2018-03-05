package com.webstore.beanvalidator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.webstore.domain.User;

@Component
public class UserValidator implements Validator {
	
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		/*
		 * if (user.getsomething... < 18 || age > 60)
		 * 
		 * { errors.rejectValue("age", "customer.age.range.invalid"); }
		 */
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "user.username.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "user.password.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "user.email.empty");
		
		if (!user.getEmail().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
			errors.rejectValue("email", "user.emailId.invalid");
		}
		
	}
	
}