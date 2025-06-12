package com.tap.model;

public class Restaurant {

	private int restaurantId; 
	private String name;
	private String imagepath;
	private float rating;
	private int eta;
	private String cuisineType;
	private String address;
	private boolean isActive;
	private int  restOwnerId;
	
	public Restaurant() {
	}
	
	public Restaurant(int restaurantId, String name, String imagepath, float rating, int eta, String cuisineType,
			String address, boolean isActive, int restOwnerId) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.imagepath = imagepath;
		this.rating = rating;
		this.eta = eta;
		this.cuisineType = cuisineType;
		this.address = address;
		this.isActive = isActive;
		this.restOwnerId = restOwnerId;
	}

	
	
	 public Restaurant(String name, String imagepath, float rating, int eta, String cuisineType,
             String address, boolean isActive, int restOwnerId) {
this.name = name;
this.imagepath = imagepath;
this.rating = rating;
this.eta = eta;
this.cuisineType = cuisineType;
this.address = address;
this.isActive = isActive;
this.restOwnerId = restOwnerId;
}
	
	public int getRestaurantId() {
		return restaurantId;
	}

	public String getName() {
		return name;
	}

	public String getImagepath() {
		return imagepath;
	}

	public float getRating() {
		return rating;
	}

	public int getEta() {
		return eta;
	}

	public String getCuisineType() {
		return cuisineType;
	}

	public String getAddress() {
		return address;
	}

	public boolean isActive() {
		return isActive;
	}

	public int getRestOwnerId() {
		return restOwnerId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void setRestOwnerId(int restOwnerId) {
		this.restOwnerId = restOwnerId;
	}
	
	
	
	
}
