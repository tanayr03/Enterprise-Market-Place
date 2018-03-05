package com.webstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.webstore.dao.UserDao;
import com.webstore.domain.Login;
import com.webstore.domain.User;
import com.webstore.service.UserService;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	public void register(User user) {
		userDao.register(user);
	}
	
	public User validateUser(Login login) {
		return userDao.validateUser(login);
	}
	
}
