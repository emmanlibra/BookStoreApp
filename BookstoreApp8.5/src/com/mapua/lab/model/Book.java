package com.mapua.lab.model;

import java.util.Random;

public class Book {
	
	private String id;
	private String name;
	private String description;
	private String author;
	private double price;
	private int stock;
	
	
	
	public Book() {
		
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price; //formatter.format(price)
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public String generateBookId() {
		Random rand = new Random();
		String random = String.valueOf(Math.abs(rand.nextInt()));
		return random;
	}
	
	public int itemNumber() {
		Random rand = new Random();
		int random = Math.abs(rand.nextInt());
		return random;
	}
	
	@Override
	public String toString() {
		return "Book [getId()=" + getId() + ", getName()=" + getName() + ", getDescription()=" + getDescription()
				+ ", getAuthor()=" + getAuthor() + ", getPrice()=" + getPrice() + ", getStock()=" + getStock() + "]";
	}
	

	
}
