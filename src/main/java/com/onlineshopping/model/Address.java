package com.onlineshopping.model;

public class Address {
	int id;
	int userId;
	String fullName;
	String mobile;
	String address;
	String city;
	String pincode;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(int id, int userId, String fullName, String mobile, String address, String city, String pincode) {
		super();
		this.id = id;
		this.userId = userId;
		this.fullName = fullName;
		this.mobile = mobile;
		this.address = address;
		this.city = city;
		this.pincode = pincode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	
}
