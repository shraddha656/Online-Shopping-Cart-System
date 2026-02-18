package com.onlineshopping.model;

import java.util.List;

public class Order {
	int orderId;
	int userId;
	int addressId;
	double totalAmount;
	String paymentType;
	List<OrderItem> items;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	

	public Order(int userId, int addressId, double totalAmount, String paymentType,
			List<OrderItem> items) {
		super();
		this.userId = userId;
		this.addressId = addressId;
		this.totalAmount = totalAmount;
		this.paymentType = paymentType;
		this.items = items;
	}



	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}



	public int getAddressId() {
		return addressId;
	}



	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}



	public String getPaymentType() {
		return paymentType;
	}



	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
	
}
