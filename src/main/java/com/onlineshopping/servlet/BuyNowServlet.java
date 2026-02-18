package com.onlineshopping.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.onlineshopping.model.Products;
import com.onlineshopping.service.ProductService;


@WebServlet("/buyNow")
public class BuyNowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	ProductService productService = new ProductService();
    	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Products p = productService.getProductById(id);
		
		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("user") == null) {
		    response.sendRedirect("userLogin.jsp");
		    return;
		}
		
		session.setAttribute("buyNow", true); 
		session.setAttribute("buyNowProduct", p);   // Store product temporarily
        session.setAttribute("buyNowQty", 1);       // Default quantity = 1

        response.sendRedirect("address.jsp");       // Go to delivery address
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
