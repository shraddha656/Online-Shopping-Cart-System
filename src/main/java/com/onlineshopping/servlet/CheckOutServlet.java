package com.onlineshopping.servlet;

import jakarta.servlet.RequestDispatcher;
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
import com.onlineshopping.model.Order;
import com.onlineshopping.model.OrderItem;
import com.onlineshopping.model.User;
import com.onlineshopping.service.OrderService;


@WebServlet("/checkout")
public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	OrderService orderservice = new OrderService();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("user") == null) {
		    response.sendRedirect("userLogin.jsp");
		    return;
		}
		
		List<CartItem> cart = (List<CartItem>)session.getAttribute("cart");
		User user = (User)session.getAttribute("user");
		
		if(cart==null||cart.isEmpty()) {
			response.sendRedirect("cart");
			return;
		}
		
		double total = 0;
		//List<OrderItem>items = new ArrayList<>();
		
		for(CartItem ci : cart) {
			total = total + ci.getTotalPrice();
			//OrderItem o = new OrderItem(ci.getProduct().getId(),ci.getQuantity(),ci.getProduct().getPrice());
			//items.add(o);
		}
		
		//Order order = new Order(user.getUserId(),total,items);
		
		//int orderId = orderservice.placeOrder(order);
		
		//session.removeAttribute("cart");
		
		request.setAttribute("orderId", total);
	    //request.setAttribute("totalAmount", total);

	    RequestDispatcher rd = request.getRequestDispatcher("address.jsp");
	    rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
