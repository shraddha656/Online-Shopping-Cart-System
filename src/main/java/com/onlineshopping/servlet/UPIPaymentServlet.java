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

@WebServlet("/upiPayment")
public class UPIPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	OrderService orderService = new OrderService();
	PaymentService paymentService = new PaymentService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("user") == null) {
		    response.sendRedirect("userLogin.jsp");
		    return;
		}

		String upiId = request.getParameter("upiId");
		
        if (upiId == null) {
            // First time coming here → show UPI page
            RequestDispatcher rd = request.getRequestDispatcher("upiPayment.jsp");
            rd.forward(request, response);
            return;
        }

		if (!upiId.contains("@")) {
			request.setAttribute("error", "Invalid UPI Id");
			RequestDispatcher rd = request.getRequestDispatcher("upiPayment.jsp");
			rd.forward(request, response);
			return;
		}

		Integer addressId = (Integer) session.getAttribute("addressId");
		User user = (User) session.getAttribute("user");

		// ⭐ FIX: If addressId missing → force user to enter address
		if (addressId == null) {
		    response.sendRedirect("address.jsp");
		    return;
		}

		if (user == null) {
		    response.sendRedirect("userLogin.jsp");
		    return;
		}

		Boolean buyNow = (Boolean) session.getAttribute("buyNow");

		// ---------------- BUY NOW FLOW ----------------
		if (buyNow != null && buyNow) {

			Products p = (Products) session.getAttribute("buyNowProduct");
			Integer qty = (Integer) session.getAttribute("buyNowQty");

			double total = p.getPrice() * qty;

			List<OrderItem> items = new ArrayList<>();
			items.add(new OrderItem(p.getId(), qty, p.getPrice()));

			Order order = new Order(user.getUserId(), addressId, total, "UPI", items);
			int orderId = orderService.placeOrder(order);

			paymentService.savePayment(new Payment(orderId, total, "UPI", "SUCCESS"));

			// Cleanup
			session.removeAttribute("buyNow");
			session.removeAttribute("buyNowProduct");
			session.removeAttribute("buyNowQty");

//			// Send via redirect (avoid null values)
//			request.setAttribute("orderId", orderId);
//			request.setAttribute("totalAmount", total);
//
//			RequestDispatcher rd = request.getRequestDispatcher("orderSuccess.jsp");
//			rd.forward(request, response);
			
			request.setAttribute("orderId", orderId);
			request.setAttribute("totalAmount", total);

			RequestDispatcher rd = request.getRequestDispatcher("orderSuccess.jsp");
			rd.forward(request, response);
			
			return;
		}

		// ---------------- NORMAL CART CHECKOUT FLOW ----------------
		List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");

		if (cart == null || cart.isEmpty()) {
			response.sendRedirect("cart.jsp");
			return;
		}

		List<OrderItem> items = new ArrayList<>();
		double total = 0;

		for (CartItem ci : cart) {
			total += ci.getTotalPrice();
			items.add(new OrderItem(ci.getProduct().getId(), ci.getQuantity(), ci.getProduct().getPrice()));
		}

		Order order = new Order(user.getUserId(), addressId, total, "UPI", items);
		int orderId = orderService.placeOrder(order);

		paymentService.savePayment(new Payment(orderId, total, "UPI", "SUCCESS"));

		// clear cart
		session.removeAttribute("cart");
		session.setAttribute("cartCount", 0);

		request.setAttribute("orderId", orderId);
		request.setAttribute("totalAmount", total);

		RequestDispatcher rd = request.getRequestDispatcher("orderSuccess.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
