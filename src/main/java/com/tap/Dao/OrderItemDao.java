package com.tap.Dao;

import java.util.List;

import com.tap.model.OrderItem;

public interface OrderItemDao {

	
	
	
	
	List<OrderItem> getAllOrderItems();

	OrderItem getOrderItem(int orderItemId);

	boolean insertOrderItem(OrderItem orderItem);
	
	    boolean updateOrderItem(OrderItem orderItem);

	    boolean deleteOrderItem(int orderItemId);


	
}
