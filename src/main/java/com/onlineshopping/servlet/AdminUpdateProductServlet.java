package com.onlineshopping.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.onlineshopping.model.Products;
import com.onlineshopping.service.AdminProductService;

@WebServlet("/adminUpdateProduct")
public class AdminUpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AdminProductService service = new AdminProductService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("admin") == null) {
		    response.sendRedirect("adminLogin.jsp");
		    return;
		}
		Products p = new Products();
		p.setId(Integer.parseInt(request.getParameter("id")));
		p.setName(request.getParameter("name"));
		p.setDescription(request.getParameter("description"));
		p.setPrice(Double.parseDouble(request.getParameter("price")));
		p.setCategory(request.getParameter("category"));
		p.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		p.setImage(request.getParameter("image"));
		
		
		
		boolean updated = service.updateProduct(p);
		
		
		if (updated) {
            response.sendRedirect("adminProductUpdated.jsp");
        } else {
            response.sendRedirect("adminError.jsp");
        }
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
