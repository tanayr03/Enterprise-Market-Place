package com.webstore.service;

import com.webstore.domain.Login;
import com.webstore.domain.User;

public interface UserService {
	
	void register(User user);
	
	User validateUser(Login login);
	
}
