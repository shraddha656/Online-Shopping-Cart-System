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
import com.onlineshopping.model.Payment;
import com.onlineshopping.model.Products;
import com.onlineshopping.model.User;
import com.onlineshopping.service.OrderService;
import com.onlineshopping.service.PaymentService;


@WebServlet("/codpayment")
public class CODPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	OrderService orderservice = new OrderService();
	PaymentService paymentService = new PaymentService();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("user") == null) {
		    response.sendRedirect("userLogin.jsp");
		    return;
		}
		
		Integer addressId = (Integer) session.getAttribute("addressId");
        User user = (User) session.getAttribute("user");
        
        if (user == null) {
            response.sendRedirect("userLogin.jsp");
            return;
        }
        
        
        //CHECK IF THIS IS BUY NOW
        
        Boolean buyNow = (Boolean) session.getAttribute("buyNow");
        
        if (buyNow != null && buyNow) {

            Products p = (Products) session.getAttribute("buyNowProduct");
            Integer qty = (Integer) session.getAttribute("buyNowQty");

            List<OrderItem> items = new ArrayList<>();
            OrderItem oi = new OrderItem(p.getId(), qty, p.getPrice());
            items.add(oi);

            double total = p.getPrice() * qty;

            Order order = new Order(user.getUserId(), addressId, total, "COD", items);
            int orderId = orderservice.placeOrder(order);

            // Save Payment
            Payment payment = new Payment(orderId, total, "COD", "SUCCESS");
            paymentService.savePayment(payment);

            // Cleanup
            session.removeAttribute("buyNow");
            session.removeAttribute("buyNowProduct");
            session.removeAttribute("buyNowQty");

            request.setAttribute("orderId", orderId);
            request.setAttribute("totalAmount", total);
            request.setAttribute("paymenthod", "Cash On Delivery");

            RequestDispatcher rd = request.getRequestDispatcher("orderSuccess.jsp");
            rd.forward(request, response);
            return;
        }
		
		//Normal flow
		List<CartItem> cart = (List<CartItem>)session.getAttribute("cart");
		if (cart == null || cart.isEmpty()) {
            response.sendRedirect("cart.jsp");
            return;
        }
		
		
		double total = 0;
		List<OrderItem>items = new ArrayList<>();
		
		for(CartItem ci : cart) {
			total = total + ci.getTotalPrice();
			OrderItem oi = new OrderItem(ci.getProduct().getId(),ci.getQuantity(),ci.getProduct().getPrice());
			items.add(oi);
		}
		
		Order order = new Order(user.getUserId(),addressId,total,"COD",items);
		
		int orderId = orderservice.placeOrder(order);
		
		Payment payment = new Payment(orderId,total,"COD","SUCCESS");
		paymentService.savePayment(payment);
		
		// Clear cart after placing order
		session.removeAttribute("cart");
		session.setAttribute("cartCount", 0);
		
		request.setAttribute("orderId", orderId);
		request.setAttribute("totalAmount", total);
		request.setAttribute("paymenthod", "Cash On Delivery");
		
		RequestDispatcher rd = request.getRequestDispatcher("orderSuccess.jsp");
		rd.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
