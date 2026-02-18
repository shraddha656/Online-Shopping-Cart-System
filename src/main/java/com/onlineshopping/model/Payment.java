package com.onlineshopping.model;

public class Payment {
	int paymentId;
	int orderId;
	double amount;
	String method;
	String status;
	
	public Payment() {
		// TODO Auto-generated constructor stub
	}

	public Payment(int orderId, double amount, String method, String status) {
		super();
		
		this.orderId = orderId;
		this.amount = amount;
		this.method = method;
		this.status = status;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
