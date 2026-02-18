package com.onlineshopping.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.onlineshopping.model.Products;
import com.onlineshopping.service.AdminProductService;


@WebServlet("/adminEditProduct")
public class AdminEditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AdminProductService service = new AdminProductService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("admin") == null) {
		    response.sendRedirect("adminLogin.jsp");
		    return;
		}
		int id = Integer.parseInt(request.getParameter("id"));
		Products p = service.getProductsById(id);
		
		 if (p == null) {
			 	System.out.println("product is getting null value");
	            response.sendRedirect("adminError.jsp");
	            return;
	        }
		
		request.setAttribute("product", p);
		RequestDispatcher rd = request.getRequestDispatcher("adminEditProduct.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
