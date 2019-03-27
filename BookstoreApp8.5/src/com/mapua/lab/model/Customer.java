package com.mapua.lab.model;

import java.util.Random;

public class Customer {
	private String customerId;
	private String customerName;
	private String customerAddress;
	private String customerContact;
	private String customerPassword;
	private String loginType;
	
	
	public String getLoginType() {
		return loginType;
	}
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerContact() {
		return customerContact;
	}
	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}
	public String getCustomerType() {
		return "customer_user";
	}
	
	public String generateCustomerId() {
		Random rand = new Random();
		String random = String.valueOf(Math.abs(rand.nextInt()));
		return random;
	}

}
