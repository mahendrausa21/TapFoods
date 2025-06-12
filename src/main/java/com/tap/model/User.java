package com.tap.model;

import java.time.LocalDateTime;



public class User {
	
	
	
	private int userId; 
	private String name;
	private String email;
	private long phoneNo;
	private String address;
	private String username;
	private String  password;
	 private LocalDateTime createdDate;
	 private LocalDateTime lastLogin;
	 private Role role;

	    public enum Role {
	        customer,
	        restowner,
	        agent,
	        admin
	    }
	
	public User() {
	}
	
	

	public User(int userId, String name, String email, long phoneNo, String address, String username, String password,
			LocalDateTime createdDate, LocalDateTime lastLogin, Role role) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
		this.address = address;
		this.username = username;
		this.password = password;
		this.createdDate = createdDate;
		this.lastLogin = lastLogin;
		this.role = role;
	}



	
	
	public int getUserId() {
		return userId;
	}



	public String getName() {
		return name;
	}



	public String getEmail() {
		return email;
	}



	public long getPhoneNo() {
		return phoneNo;
	}



	public String getAddress() {
		return address;
	}



	public String getUsername() {
		return username;
	}



	public String getPassword() {
		return password;
	}



	public LocalDateTime getCreatedDate() {
		return createdDate;
	}



	public LocalDateTime getLastLogin() {
		return lastLogin;
	}



	public Role getRole() {
		return role;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}



	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}



	public void setRole(Role role) {
		this.role = role;
	}



	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", phoneNo=" + phoneNo + ", address="
				+ address + ", username=" + username + ", password=" + password + ", createdDate=" + createdDate
				+ ", lastLogin=" + lastLogin + ", role=" + role + "]";
	}



	

	
	
}
