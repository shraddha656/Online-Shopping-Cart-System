package com.onlineshopping.service;

import com.onlineshopping.DAO.UserDAO;
import com.onlineshopping.model.User;


public class UserService {
	
	UserDAO userDAO = new UserDAO();

	public boolean registerUser(User user) {
		if(user.getEmail()==null||user.getPassword()==null) {
			return false;
		}
		return userDAO.register(user);
	}

	public User validateUser(String email, String password) {
		
		return userDAO.login(email,password);
	}

}
