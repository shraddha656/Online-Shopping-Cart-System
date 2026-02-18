package com.onlineshopping.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.onlineshopping.model.CartItem;
import com.onlineshopping.model.Products;
import com.onlineshopping.service.ProductService;


@WebServlet("/addtocart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	ProductService productService = new ProductService();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("user") == null) {
		    response.sendRedirect("userLogin.jsp");
		    return;
		}
		
		int id = Integer.parseInt(request.getParameter("id"));
		Products product = productService.getProductById(id);
		
		
		List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
		
		if(cart==null) {
			cart = new ArrayList<>();
		}
		
		boolean found = false;
		
		for(CartItem item : cart) {
			if(item.getProduct().getId()==id) {
				item.setQuantity(item.getQuantity()+1);
				found=true;
				break;
			}
		}
		
		if(!found) {
			cart.add(new CartItem(product,1));
		}
		
		session.setAttribute("cart", cart);
		
		session.setAttribute("cartCount", cart.size()); //updates cart icon count
		
		response.sendRedirect("cart");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
