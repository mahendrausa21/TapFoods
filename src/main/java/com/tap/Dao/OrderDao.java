package com.tap.Dao;

import java.util.List;

import com.tap.model.Order;

public interface OrderDao {

	
	
	 List<Order> getAllOrders(); 
	    
	    Order getOrder(int orderId);
	    
	    boolean insertOrder(Order order); 
	    
	    boolean updateOrder(Order order); 
	    
	    boolean deleteOrder(int orderId);

		int getLatestOrderIdByUser(int userId);
	
	
}
