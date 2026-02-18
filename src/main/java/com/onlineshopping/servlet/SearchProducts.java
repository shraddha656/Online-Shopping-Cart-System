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
import com.onlineshopping.service.ProductService;


@WebServlet("/searchProducts")
public class SearchProducts extends HttpServlet {
	
	ProductService service = new ProductService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("user") == null) {
		    response.sendRedirect("userLogin.jsp");
		    return;
		}
		List<Products>list = service.searchProducts(keyword);
		
		request.setAttribute("productList", list);
		request.setAttribute("keyword", keyword);
		
		RequestDispatcher rd = request.getRequestDispatcher("products.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
