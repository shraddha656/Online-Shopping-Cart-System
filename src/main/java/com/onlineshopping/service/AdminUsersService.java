package com.onlineshopping.service;

import java.util.List;

import com.onlineshopping.DAO.UserDAO;
import com.onlineshopping.model.User;

public class AdminUsersService {

	UserDAO dao = new UserDAO();
	
	public List<User>getAllUsers(){
		return dao.getAllUsers();
	}
}
