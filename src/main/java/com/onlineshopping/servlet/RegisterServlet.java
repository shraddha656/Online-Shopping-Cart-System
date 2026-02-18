package com.onlineshopping.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.onlineshopping.model.User;
import com.onlineshopping.service.UserService;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	UserService us = new UserService();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setRole("user");
		
		boolean isRegistered = us.registerUser(user);
		if(isRegistered) {
			response.sendRedirect("userLogin.jsp");
		}
		else {
			response.sendRedirect("register.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
