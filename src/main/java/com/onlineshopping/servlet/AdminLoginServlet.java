package com.onlineshopping.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        String email = request.getParameter("email");
	        String password = request.getParameter("password");

	        // Example login: you must check DB values here
	        if(email.equals("admin@gmail.com") && password.equals("admin123")) {

	            HttpSession session = request.getSession();
	            session.setAttribute("admin", email);

	            response.sendRedirect("adminDashboard.jsp"); // SUCCESS
	        } else {
	            request.setAttribute("error", "Invalid email or password!");
	            request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
	        }
	    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
