package com.tap.model;

public class OrderHistory {
	
	 private int orderHistoryId;
	    private int orderId;
	    private int userId;
	    
	    public OrderHistory() {
		}

		public OrderHistory(int orderHistoryId, int orderId, int userId) {
			super();
			this.orderHistoryId = orderHistoryId;
			this.orderId = orderId;
			this.userId = userId;
		}

		public int getOrderHistoryId() {
			return orderHistoryId;
		}

		public int getOrderId() {
			return orderId;
		}

		public int getUserId() {
			return userId;
		}

		public void setOrderHistoryId(int orderHistoryId) {
			this.orderHistoryId = orderHistoryId;
		}

		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

	    
		
		
	    
	    
	    
	    
	    
	    
}
