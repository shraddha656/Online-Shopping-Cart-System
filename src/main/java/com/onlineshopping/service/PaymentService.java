package com.onlineshopping.service;

import com.onlineshopping.DAO.PaymentDAO;
import com.onlineshopping.model.Payment;

public class PaymentService {
	PaymentDAO dao = new PaymentDAO();
	
	public boolean savePayment(Payment p) {
		return dao.savePayment(p);
	}
}
