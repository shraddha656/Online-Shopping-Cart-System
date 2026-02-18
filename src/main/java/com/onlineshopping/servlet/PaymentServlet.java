package com.onlineshopping.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.onlineshopping.model.Payment;
import com.onlineshopping.model.Products;
import com.onlineshopping.service.OrderService;


@WebServlet("/payment")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("user") == null) {
		    response.sendRedirect("userLogin.jsp");
		    return;
		}
		Boolean buyNow = (Boolean)session.getAttribute("buyNow");
		
		String method = request.getParameter("method");
		
		
		//Normal Flow without buyNow option
		if(buyNow==null) {
		if(method.equals("COD")) {
			response.sendRedirect("codpayment");
		}
		else if(method.equals("UPI")) {
			RequestDispatcher rd = request.getRequestDispatcher("upiPayment.jsp");
			rd.forward(request, response);
		}
		else if(method.equals("CARD")) {
			RequestDispatcher rd = request.getRequestDispatcher("cardPayment.jsp");
			rd.forward(request, response);
		}
		return;
		}
		
		// BUY NOW FLOW
        Products p = (Products) session.getAttribute("buyNowProduct");
        Integer qty = (Integer) session.getAttribute("buyNowQty");
        Integer userId = (Integer) session.getAttribute("userId");
        Integer addressId = (Integer) session.getAttribute("addressId");
        if (addressId == null) {
            response.sendRedirect("address.jsp");
            return;
        }
        
        
        //for upi method
        if (method.equals("UPI")) {
            RequestDispatcher rd = request.getRequestDispatcher("upiPayment.jsp");
            rd.forward(request, response);
            return;
        }
        
        if (method.equals("CARD")) {
            RequestDispatcher rd = request.getRequestDispatcher("cardPayment.jsp");
            rd.forward(request, response);
            return;
        }
        
        OrderService service = new OrderService();
        int orderId = service.placeSingleOrder(userId, p, qty, method, addressId);

        // cleanup
        session.removeAttribute("buyNow");
        session.removeAttribute("buyNowProduct");
        session.removeAttribute("buyNowQty");
        
        request.setAttribute("orderId", orderId);
        request.setAttribute("totalAmount", p.getPrice() * qty);

        RequestDispatcher rd = request.getRequestDispatcher("orderSuccess.jsp");
        rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
