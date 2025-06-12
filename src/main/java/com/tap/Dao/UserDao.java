package com.tap.Dao;

import java.util.List;

import com.tap.model.User;

public interface UserDao {

	List<User> getAll();
	
	User getUser(int userid);
	
	boolean insertUser(User user);
	
	boolean updateUser(User user);
	
	boolean deleteUser(int userid);
	
	 User validateUser(String email, String password);
	
	
	
	
	
	
	
	
	
	
	
	
	
}
