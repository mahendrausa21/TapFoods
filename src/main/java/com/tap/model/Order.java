package com.tap.model;

public class Order {

	
	
	  private int orderId;
	    private int restaurantId;
	    private int userId;
	    private double totalAmount;
	    private ModeOfPayment modeOfPayment;
	    private Status status;

	    public enum ModeOfPayment {
	        upi,
	        debitcard,
	        creditcard,
	        cash
	    }

	    public enum Status {
	        confirmed,
	        dispacted,
	        delivered
	    }
	    
	    public Order() {
		}

		public Order(int orderId, int restaurantId, int userId, double totalAmount, ModeOfPayment modeOfPayment,
				Status status) {
			super();
			this.orderId = orderId;
			this.restaurantId = restaurantId;
			this.userId = userId;
			this.totalAmount = totalAmount;
			this.modeOfPayment = modeOfPayment;
			this.status = status;
		}

		public int getOrderId() {
			return orderId;
		}

		public int getRestaurantId() {
			return restaurantId;
		}

		public int getUserId() {
			return userId;
		}

		public double getTotalAmount() {
			return totalAmount;
		}

		public ModeOfPayment getModeOfPayment() {
			return modeOfPayment;
		}

		public Status getStatus() {
			return status;
		}

		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}

		public void setRestaurantId(int restaurantId) {
			this.restaurantId = restaurantId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public void setTotalAmount(double totalAmount) {
			this.totalAmount = totalAmount;
		}

		public void setModeOfPayment(ModeOfPayment modeOfPayment) {
			this.modeOfPayment = modeOfPayment;
		}

		public void setStatus(Status status) {
			this.status = status;
		}

	    
	    
}
