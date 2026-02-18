package com.onlineshopping.service;

import java.util.List;

import com.onlineshopping.DAO.AdminOrderDAO;
import com.onlineshopping.model.AdminOrderView;

public class AdminOrderService {

	AdminOrderDAO dao = new AdminOrderDAO();
	
	public List<AdminOrderView> getAllOrders() {
        return dao.getAllOrders();
    }
}
