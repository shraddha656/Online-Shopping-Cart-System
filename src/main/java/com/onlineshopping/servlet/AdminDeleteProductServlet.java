package com.onlineshopping.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.onlineshopping.service.AdminProductService;


@WebServlet("/adminDeleteProduct")
public class AdminDeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AdminProductService service = new AdminProductService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("admin") == null) {
		    response.sendRedirect("adminLogin.jsp");
		    return;
		}
		String idStr = request.getParameter("id");
		
		 if (idStr == null || idStr.trim().isEmpty()) {
	            System.out.println("Delete product failed — ID missing");
	            response.sendRedirect("adminError.jsp");
	            return;
	        }

	        int id = Integer.parseInt(idStr);

	        boolean deleted = service.deleteProduct(id);

	        if (deleted) {
	            response.sendRedirect("adminProductDeleted.jsp");
	        } else {
	            response.sendRedirect("adminError.jsp");
	        }
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
