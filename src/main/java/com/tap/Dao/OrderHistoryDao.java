package com.tap.Dao;

import java.util.List;

import com.tap.model.OrderHistory;

public interface OrderHistoryDao {

	
	
	   List<OrderHistory> getAllOrderHistories();

	    OrderHistory getOrderHistory(int orderHistoryId);

	    boolean insertOrderHistory(OrderHistory orderHistory);

	    boolean updateOrderHistory(OrderHistory orderHistory);

	    boolean deleteOrderHistory(int orderHistoryId);
	
	
}
