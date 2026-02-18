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

/**
 * Servlet implementation class CardPaymentServlet
 */
@WebServlet("/cardpayment")
public class CardPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	OrderService orderService = new OrderService();
	PaymentService paymentService = new PaymentService();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("user") == null) {
		    response.sendRedirect("userLogin.jsp");
		    return;
		}
		
		String cardNumber  = request.getParameter("cardNo");
        String cvv = request.getParameter("cvv");
        
     // First time → show card payment page
        if (cardNumber == null || cvv == null) {
            RequestDispatcher rd = request.getRequestDispatcher("cardPayment.jsp");
            rd.forward(request, response);
            return;
        }

        // Simple validation
        if (cardNumber.length() != 16 || cvv.length() != 3) {
            request.setAttribute("error", "Invalid Card Details");
            RequestDispatcher rd = request.getRequestDispatcher("cardPayment.jsp");
            rd.forward(request, response);
            return;
        }

        Integer addressId = (Integer) session.getAttribute("addressId");
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("userLogin.jsp");
            return;
        }

        if (addressId == null) {
            response.sendRedirect("address.jsp");
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

            Order order = new Order(user.getUserId(), addressId, total, "CARD", items);
            int orderId = orderService.placeOrder(order);

            paymentService.savePayment(new Payment(orderId, total, "CARD", "SUCCESS"));

            // Cleanup
            session.removeAttribute("buyNow");
            session.removeAttribute("buyNowProduct");
            session.removeAttribute("buyNowQty");

            request.setAttribute("orderId", orderId);
            request.setAttribute("totalAmount", total);

            RequestDispatcher rd = request.getRequestDispatcher("orderSuccess.jsp");
            rd.forward(request, response);
            return;
        }

        // ---------------- ADD TO CART FLOW ----------------
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");

        if (cart == null || cart.isEmpty()) {
            response.sendRedirect("cart.jsp");
            return;
        }

        double total = 0;
        List<OrderItem> items = new ArrayList<>();

        for (CartItem ci : cart) {
            total += ci.getTotalPrice();
            items.add(new OrderItem(ci.getProduct().getId(), ci.getQuantity(), ci.getProduct().getPrice()));
        }

        Order order = new Order(user.getUserId(), addressId, total, "CARD", items);
        int orderId = orderService.placeOrder(order);

        paymentService.savePayment(new Payment(orderId, total, "CARD", "SUCCESS"));

        session.removeAttribute("cart");
        session.setAttribute("cartCount", 0);

        request.setAttribute("orderId", orderId);
        request.setAttribute("totalAmount", total);

        RequestDispatcher rd = request.getRequestDispatcher("orderSuccess.jsp");
        rd.forward(request, response);
        }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
