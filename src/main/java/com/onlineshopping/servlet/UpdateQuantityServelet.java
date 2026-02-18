package com.onlineshopping.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.onlineshopping.model.CartItem;
import com.onlineshopping.model.Products;
import com.onlineshopping.service.ProductService;


@WebServlet("/updatequantity")
public class UpdateQuantityServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	ProductService productService = new ProductService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("id"));
        int newQty = Integer.parseInt(request.getParameter("quantity"));
	    
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("userLogin.jsp");
            return;
        }

        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("userLogin.jsp");
            return;
        }
	        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
	        
	        //FETCH PRODUCT STOCK FROM DATABASE
	        Products p = productService.getProductById(productId);

	        // 🔥 STOCK CHECK
	        if (newQty > p.getQuantity()) {
	            request.setAttribute("error", "❌ Only " + p.getQuantity() + " items available in stock.");
	            request.setAttribute("cartItems", cart);  // so cart.jsp displays items again
	            request.getRequestDispatcher("cart.jsp").forward(request, response);
	            return;
	        }
	
	        for(CartItem item : cart) {
	        	if(item.getProduct().getId()==productId) {
	        		item.setQuantity(newQty);
	        		break;
	        	}
	        }
	        
	        session.setAttribute("cart", cart);
	        response.sendRedirect("cart");
	        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
