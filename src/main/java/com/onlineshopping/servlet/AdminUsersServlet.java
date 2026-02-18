package com.onlineshopping.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.onlineshopping.model.User;
import com.onlineshopping.service.AdminUsersService;


@WebServlet("/adminUsers")
public class AdminUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	AdminUsersService service = new AdminUsersService();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("admin") == null) {
		    response.sendRedirect("adminLogin.jsp");
		    return;
		}
		List<User>users = service.getAllUsers();
		request.setAttribute("users", users);
		
		RequestDispatcher rd = request.getRequestDispatcher("adminUsers.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
