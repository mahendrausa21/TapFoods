package com.tapDaoIMp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.Dao.OrderDao;
import com.tap.model.Order;
import com.tap.model.Order.ModeOfPayment;
import com.tap.model.Order.Status;

public class OrderDaoImp implements OrderDao  {

	@Override
	public List<Order> getAllOrders() {


		  List<Order> list = new ArrayList<>();
	        String query = "SELECT * FROM `order`";  
	        
	        try (Connection con = ConnectionFactory.getConnection();
	             PreparedStatement pst = con.prepareStatement(query);
	             ResultSet rs = pst.executeQuery()) {
	             
	            while (rs.next()) {
	                int orderId = rs.getInt("orderId");
	                int restaurantId = rs.getInt("restaurantId");
	                int userId = rs.getInt("userId");
	                double totalAmount = rs.getDouble("totalAmount");
	                ModeOfPayment modeOfPayment = ModeOfPayment.valueOf(rs.getString("modeOfPayment"));
	                Status status = Status.valueOf(rs.getString("status"));
	                
	                Order order = new Order(orderId, restaurantId, userId, totalAmount, modeOfPayment, status);
	                list.add(order);
	            }
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	        
	        return list;
	  }
		
	

	@Override
	public Order getOrder(int orderId) {
		
		 Order order = null;
	        String query = "SELECT * FROM `order` WHERE orderId = ?";
	        
	        try (Connection con = ConnectionFactory.getConnection();
	             PreparedStatement pst = con.prepareStatement(query)) {
	             
	            pst.setInt(1, orderId);
	            ResultSet rs = pst.executeQuery();
	            
	            if (rs.next()) {
	                int restaurantId = rs.getInt("restaurantId");
	                int userId = rs.getInt("userId");
	                double totalAmount = rs.getDouble("totalAmount");
	                ModeOfPayment modeOfPayment = ModeOfPayment.valueOf(rs.getString("modeOfPayment"));
	                Status status = Status.valueOf(rs.getString("status"));
	                
	                order = new Order(orderId, restaurantId, userId, totalAmount, modeOfPayment, status);
	            }
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	        
	        return order;
	}

	@Override
	public boolean insertOrder(Order order) {
		 String query = "INSERT INTO `order` (restaurantId, userId, totalAmount, modeOfPayment, status) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
             
            pst.setInt(1, order.getRestaurantId());
            pst.setInt(2, order.getUserId());
            pst.setDouble(3, order.getTotalAmount());
            pst.setString(4, order.getModeOfPayment().name());
            pst.setString(5, order.getStatus().name());
            
            int i = pst.executeUpdate();
            return i == 1;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        
        return false;
	}

	@Override
	public boolean updateOrder(Order order) {
		
String query = "UPDATE `order` SET restaurantId = ?, userId = ?, totalAmount = ?, modeOfPayment = ?, status = ? WHERE orderId = ?";
        
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
             
            pst.setInt(1, order.getRestaurantId());
            pst.setInt(2, order.getUserId());
            pst.setDouble(3, order.getTotalAmount());
            pst.setString(4, order.getModeOfPayment().name());
            pst.setString(5, order.getStatus().name());
            pst.setInt(6, order.getOrderId());
            
            int i = pst.executeUpdate();
            return i == 1;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        
        return false;
	}

	@Override
	public boolean deleteOrder(int orderId) {
	
		 String query = "DELETE FROM `order` WHERE orderId = ?";
	        
	        try (Connection con = ConnectionFactory.getConnection();
	             PreparedStatement pst = con.prepareStatement(query)) {
	             
	            pst.setInt(1, orderId);
	            
	            int i = pst.executeUpdate();
	            return i == 1;
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	        
	        return false;
		
	}

	
	@Override
	public int getLatestOrderIdByUser(int userId) {
	    int orderId = -1;
	    String query = "SELECT orderId FROM `order` WHERE userId = ? ORDER BY orderId DESC LIMIT 1";

	    try (Connection con = ConnectionFactory.getConnection();
	         PreparedStatement pst = con.prepareStatement(query)) {
	        
	        pst.setInt(1, userId);
	        ResultSet rs = pst.executeQuery();
	        
	        if (rs.next()) {
	            orderId = rs.getInt("orderId");
	        }
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }

	    return orderId;
	}

	
}
