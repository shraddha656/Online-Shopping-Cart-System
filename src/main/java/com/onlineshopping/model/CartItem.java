package com.onlineshopping.model;

public class CartItem {
	Products product;
	int quantity;
	
	public CartItem() {
		// TODO Auto-generated constructor stub
	}

	public CartItem(Products product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getTotalPrice() {
		return product.getPrice() * quantity;
	}
}
