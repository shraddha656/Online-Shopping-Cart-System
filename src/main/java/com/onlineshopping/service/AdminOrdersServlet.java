package com.onlineshopping.service;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.onlineshopping.model.AdminOrderView;


@WebServlet("/adminOrders")
public class AdminOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    AdminOrderService service = new AdminOrderService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<AdminOrderView>list = service.getAllOrders();
		
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("adminOrders.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
