package com.onlineshopping.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.onlineshopping.model.Address;
import com.onlineshopping.model.User;
import com.onlineshopping.service.AddressService;


@WebServlet("/saveaddress")
public class SaveAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
		AddressService service = new AddressService();
	
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		HttpSession session = request.getSession(false);

    		if (session == null || session.getAttribute("user") == null) {
    		    response.sendRedirect("userLogin.jsp");
    		    return;
    		}
		User user = (User) session.getAttribute("user");
		Address address = new Address();
		address.setUserId(user.getUserId());
		address.setFullName(request.getParameter("fullname"));
		address.setMobile(request.getParameter("mobile"));
		address.setAddress(request.getParameter("address"));
		address.setCity(request.getParameter("city"));
		address.setPincode(request.getParameter("pincode"));
		
		int addressId = service.saveAddess(address);  // Save in DB
		
		session.setAttribute("addressId", addressId); //save address for later
		
		// Check if this is BUY NOW flow
        Boolean buyNow = (Boolean) session.getAttribute("buyNow");

        if (buyNow != null && buyNow == true) {
            // Redirect to payment options directly
            response.sendRedirect("payment.jsp");
            return;
        }
		
		response.sendRedirect("addressSuccess.jsp");  // Normal checkout flow
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
