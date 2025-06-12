package com.tap.model;

public class Menu {
	
	
	private int	menuId;
	private String name;
	private double price;
	private String description;
	private String imagepath;
	private boolean isAvailable;
	private int restaurantId;
	private float rating;
	
	public Menu() {
	}

	public Menu(int menuId, String name, double price, String description, String imagepath, boolean isAvailable,
			int restaurantId, float rating) {
		super();
		this.menuId = menuId;
		this.name = name;
		this.price = price;
		this.description = description;
		this.imagepath = imagepath;
		this.isAvailable = isAvailable;
		this.restaurantId = restaurantId;
		this.rating = rating;
	}

	public int getMenuId() {
		return menuId;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	public String getImagepath() {
		return imagepath;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public float getRating() {
		return rating;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	
	
	
}
