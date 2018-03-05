package com.webstore.dao;

import com.webstore.domain.Login;
import com.webstore.domain.User;

public interface UserDao {
	
	void register(User user);
	
	User validateUser(Login login);
}