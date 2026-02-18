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

import com.onlineshopping.model.Products;
import com.onlineshopping.service.AdminProductService;


@WebServlet("/adminProductsList")
public class AdminProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	AdminProductService service = new AdminProductService();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("admin") == null) {
			System.out.println("inside adminproduct servlet");
		    response.sendRedirect("adminLogin.jsp");
		    return;
		}
		List<Products>list = service.getAllProducts();
		request.setAttribute("list", list);
		
		//System.out.println("inside admin product servlet");
		
		RequestDispatcher rd = request.getRequestDispatcher("adminProducts.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
