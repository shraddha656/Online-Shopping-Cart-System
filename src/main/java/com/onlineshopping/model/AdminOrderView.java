package com.onlineshopping.model;

public class AdminOrderView {
	int orderId;
    String customerName;
    String mobile;
    String city;
    double totalAmount;
    String paymentType;
    String paymentStatus;
    
    public AdminOrderView() {
		// TODO Auto-generated constructor stub
	}

	public AdminOrderView(int orderId, String customerName, String mobile, String city, double totalAmount,
			String paymentType, String paymentStatus) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.mobile = mobile;
		this.city = city;
		this.totalAmount = totalAmount;
		this.paymentType = paymentType;
		this.paymentStatus = paymentStatus;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
    
    
}
