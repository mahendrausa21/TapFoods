package com.tap.model;

public class Cart {
	
	private int itemId;
	private int restaurantId;
	private String name;
	private double price;
	private int quantity;
	private String imagePath; // NEW FIELD for image
	private float rating;
	

	public Cart() {
	}

	// New Constructor with imagePath

	public Cart(int itemId, int restaurantId, String name, double price, int quantity, String imagePath, float rating) {
		super();
		this.itemId = itemId;
		this.restaurantId = restaurantId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.imagePath = imagePath;
		this.rating = rating;
	}

	

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	// Getters and Setters
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getImagePath() { // NEW Getter
		return imagePath;
	}

	public void setImagePath(String imagePath) { // NEW Setter
		this.imagePath = imagePath;
	}
}
