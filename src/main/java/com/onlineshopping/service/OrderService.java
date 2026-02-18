package com.onlineshopping.service;

import java.util.List;

import com.onlineshopping.DAO.OrderDAO;
import com.onlineshopping.model.Order;
import com.onlineshopping.model.OrderItem;
import com.onlineshopping.model.Products;

public class OrderService {
	OrderDAO dao = new OrderDAO();
	
	public int placeOrder(Order order) {
		return dao.saveOrder(order);
	}
	
	public List<Order> getOrdersByUser(int userId) {
        return dao.getOrdersByUser(userId);
    }

	public int placeSingleOrder(Integer userId, Products p, Integer qty, String method, int addressId) {
		  Order order = new Order();
		    order.setUserId(userId);
		    order.setAddressId(addressId);
		    order.setPaymentType(method);
		    order.setTotalAmount(p.getPrice() * qty);

		    OrderItem item = new OrderItem();
		    item.setProductId(p.getId());
		    item.setQuantity(qty);
		    item.setPrice(p.getPrice());

		    order.setItems(List.of(item));

		    return dao.saveSingleOrder(order);
	}
}
