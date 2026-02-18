package com.onlineshopping.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.onlineshopping.model.User;
import com.onlineshopping.service.UserService;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserService us = new UserService();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = us.validateUser(email,password);
		HttpSession session = request.getSession();
		session.setAttribute("userId", user.getUserId());
		
		if(user!=null) {
			//HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			if("admin".equals(user.getRole())) {
				response.sendRedirect("adminDashboard.jsp");
			}
			else {
				response.sendRedirect("products");
			}
		}
		else {
			response.sendRedirect("userLogin.jsp");
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
