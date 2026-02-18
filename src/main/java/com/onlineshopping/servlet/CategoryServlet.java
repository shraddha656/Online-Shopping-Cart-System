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


@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
	
	ProductService service = new ProductService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("user") == null) {
		    response.sendRedirect("userLogin.jsp");
		    return;
		}
		String category = request.getParameter("type");
		List<Products>list = service.getProductsByCategory(category);
		
		request.setAttribute("productList", list);
		request.setAttribute("category", category);
		
		RequestDispatcher rd = request.getRequestDispatcher("products.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
