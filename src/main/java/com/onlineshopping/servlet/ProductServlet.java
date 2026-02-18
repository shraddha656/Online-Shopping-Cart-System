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


@WebServlet("/products")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	    ProductService productService = new ProductService(); 
       
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    		HttpSession session = request.getSession(false);

    		if (session == null || session.getAttribute("user") == null) {
    		    response.sendRedirect("userLogin.jsp");
    		    return;
    		}
		 	List<Products> products = productService.getAllProducts();
			request.setAttribute("productList", products);
			RequestDispatcher rd = request.getRequestDispatcher("products.jsp");
			rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
