package com.tapDaoIMp;
import com.tap.Dao.UserDao; 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.tapDaoIMp.ConnectionFactory;

import com.tap.model.User;

public class UserDaoImp implements UserDao{

	@Override
	public List<User> getAll() {
		
		 List<User> list = new ArrayList<>();
		    String query = "SELECT * FROM user"; 

		    try (
		    	Connection con = ConnectionFactory.getConnection();
		         Statement stmt = con.createStatement();
		         ResultSet rs = stmt.executeQuery(query)) {

		        while (rs.next()) {
		            int userId = rs.getInt("userId");
		            String name = rs.getString("name");
		            String email = rs.getString("email");
		            long phoneNo = rs.getLong("phoneNo");
		            String address = rs.getString("address");
		            String username = rs.getString("username");
		            String password = rs.getString("password");

		            Timestamp createdTs = rs.getTimestamp("createddate");
		            LocalDateTime createdDate = createdTs != null ? createdTs.toLocalDateTime() : null;

		            Timestamp lastLoginTs = rs.getTimestamp("lastlogin");
		            LocalDateTime lastLogin = lastLoginTs != null ? lastLoginTs.toLocalDateTime() : null;

		            String roleStr = rs.getString("role");
		            User.Role role = null;
		            if (roleStr != null) {
		                try {
		                    role = User.Role.valueOf(roleStr);
		                } catch (IllegalArgumentException e) {
		                    role = null;
		                }
		            }

		            User user = new User(userId, name, email, phoneNo, address, username, password, createdDate, lastLogin, role);
		            list.add(user);
		        }

		    } catch (SQLException | ClassNotFoundException e) {
		        e.printStackTrace();
		    }

		    return list;
	}

	

	@Override
	public User getUser(int userid) {

		 String sql = "SELECT * FROM user WHERE userId = ?";
		    User user = null;

		    try (Connection con = ConnectionFactory.getConnection();
		         PreparedStatement ps = con.prepareStatement(sql)) {

		        ps.setInt(1, userid);
		        ResultSet rs = ps.executeQuery();

		        if (rs.next()) {
		            int userId = rs.getInt("userId");
		            String name = rs.getString("name");
		            String email = rs.getString("email");
		            long phoneNo = rs.getLong("phoneNo");
		            String address = rs.getString("address");
		            String username = rs.getString("username");
		            String password = rs.getString("password");

		            Timestamp createdTs = rs.getTimestamp("createddate");
		            LocalDateTime createdDate = createdTs != null ? createdTs.toLocalDateTime() : null;

		            Timestamp lastLoginTs = rs.getTimestamp("lastlogin");
		            LocalDateTime lastLogin = lastLoginTs != null ? lastLoginTs.toLocalDateTime() : null;

		            String roleStr = rs.getString("role");
		            User.Role role = null;
		            if (roleStr != null) {
		                try {
		                    role = User.Role.valueOf(roleStr);
		                } catch (IllegalArgumentException e) {
		                    role = null;
		                }
		            }

		            user = new User(userId, name, email, phoneNo, address, username, password, createdDate, lastLogin, role);
		        }

		    } catch (SQLException | ClassNotFoundException e) {
		        e.printStackTrace();
		    }

		    return user;
	
	
	
	}

	@Override
	public boolean insertUser(User user) {
		  String sql = "INSERT INTO `user` (name, email, phoneNo, address, username, password, role) VALUES (?, ?, ?, ?, ?, ?, ?)";

		    try (Connection con = ConnectionFactory.getConnection();
		         PreparedStatement ps = con.prepareStatement(sql)) {

		        ps.setString(1, user.getName());
		        ps.setString(2, user.getEmail());
		        ps.setLong(3, user.getPhoneNo());
		        ps.setString(4, user.getAddress());
		        ps.setString(5, user.getUsername());
		        ps.setString(6, user.getPassword());
		        ps.setString(7, user.getRole() != null ? user.getRole().name() : null);

		        int rowsAffected = ps.executeUpdate();
		        return rowsAffected > 0;

		    } catch (SQLException | ClassNotFoundException e) {
		        e.printStackTrace();
		        return false;
		    }
	
	
	
	}

	@Override
	public boolean updateUser(User user) {
		
		String sql = "UPDATE `user` SET name = ?, email = ?, phoneNo = ?, address = ?, username = ?, password = ?, role = ? WHERE userId = ?";

	    try (Connection con = ConnectionFactory.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setString(1, user.getName());
	        ps.setString(2, user.getEmail());
	        ps.setLong(3, user.getPhoneNo());
	        ps.setString(4, user.getAddress());
	        ps.setString(5, user.getUsername());
	        ps.setString(6, user.getPassword());
	        ps.setString(7, user.getRole() != null ? user.getRole().name() : null);
	        ps.setInt(8, user.getUserId());

	        int rowsUpdated = ps.executeUpdate();
	        return rowsUpdated > 0;

	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	        return false;
	    }
		
	}

	@Override
	public boolean deleteUser(int userid) {
		
		 String sql = "DELETE FROM `user` WHERE userId = ?";

		    try (Connection con = ConnectionFactory.getConnection();
		         PreparedStatement ps = con.prepareStatement(sql)) {

		        ps.setInt(1, userid);

		        int rowsDeleted = ps.executeUpdate();
		        return rowsDeleted > 0;

		    } catch (SQLException | ClassNotFoundException e) {
		        e.printStackTrace();
		        return false;
		    }
	
	}

	
	@Override
	public User validateUser(String email, String password) {
	    String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
	    User user = null;

	    try (Connection con = ConnectionFactory.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setString(1, email);
	        ps.setString(2, password);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            int userId = rs.getInt("userId");
	            String name = rs.getString("name");
	            long phoneNo = rs.getLong("phoneNo");
	            String address = rs.getString("address");
	            String username = rs.getString("username");

	            Timestamp createdTs = rs.getTimestamp("createddate");
	            LocalDateTime createdDate = createdTs != null ? createdTs.toLocalDateTime() : null;

	            Timestamp lastLoginTs = rs.getTimestamp("lastlogin");
	            LocalDateTime lastLogin = lastLoginTs != null ? lastLoginTs.toLocalDateTime() : null;

	            String roleStr = rs.getString("role");
	            User.Role role = null;
	            if (roleStr != null) {
	                try {
	                    role = User.Role.valueOf(roleStr);
	                } catch (IllegalArgumentException e) {
	                    role = null;
	                }
	            }

	            user = new User(userId, name, email, phoneNo, address, username, password, createdDate, lastLogin, role);
	        }

	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	    }

	    return user;
	}


	
}
