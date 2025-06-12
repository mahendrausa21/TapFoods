package com.tap.model;

public class OrderItem {

	private int orderItemId;
	private int userId; 
	private int menuId;
	private String name;
	private float rating;
	private int quantity;
	private double price;
	private int orderId;
	
	
	public OrderItem() {
	}


	public OrderItem(int orderItemId, int userId, int menuId, String name, float rating, int quantity, double price,
			int orderId) {
		super();
		this.orderItemId = orderItemId;
		this.userId = userId;
		this.menuId = menuId;
		this.name = name;
		this.rating = rating;
		this.quantity = quantity;
		this.price = price;
		this.orderId = orderId;
	}


	public int getOrderItemId() {
		return orderItemId;
	}


	public int getUserId() {
		return userId;
	}


	public int getMenuId() {
		return menuId;
	}


	public String getName() {
		return name;
	}


	public float getRating() {
		return rating;
	}


	public int getQuantity() {
		return quantity;
	}


	public double getPrice() {
		return price;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setRating(float rating) {
		this.rating = rating;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	
	
	
}