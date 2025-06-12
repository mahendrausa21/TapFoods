package com.tapDaoIMp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.Dao.OrderHistoryDao;
import com.tap.model.OrderHistory;

public class OrderHistoryDaoImp implements OrderHistoryDao {

	
	
	 @Override
	    public List<OrderHistory> getAllOrderHistories() {
	        String query = "SELECT * FROM orderhistory";
	        List<OrderHistory> list = new ArrayList<>();

	        try (
	            Connection con = ConnectionFactory.getConnection();
	            PreparedStatement pst = con.prepareStatement(query);
	            ResultSet res = pst.executeQuery()
	        ) {
	            while (res.next()) {
	                int orderHistoryId = res.getInt(1);
	                int orderId = res.getInt(2);
	                int userId = res.getInt(3);

	                OrderHistory history = new OrderHistory(orderHistoryId, orderId, userId);
	                list.add(history);
	            }
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
	    }

	    @Override
	    public OrderHistory getOrderHistory(int orderHistoryId) {
	        String query = "SELECT * FROM orderhistory WHERE orderHistoryId = ?";
	        OrderHistory history = null;

	        try (
	            Connection con = ConnectionFactory.getConnection();
	            PreparedStatement pst = con.prepareStatement(query)
	        ) {
	            pst.setInt(1, orderHistoryId);
	            ResultSet res = pst.executeQuery();

	            if (res.next()) {
	                int orderId = res.getInt(2);
	                int userId = res.getInt(3);

	                history = new OrderHistory(orderHistoryId, orderId, userId);
	            }
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	        return history;
	    }

	    @Override
	    public boolean insertOrderHistory(OrderHistory orderHistory) {
	        String query = "INSERT INTO orderhistory (orderId, userId) VALUES (?, ?)";

	        try (
	            Connection con = ConnectionFactory.getConnection();
	            PreparedStatement pst = con.prepareStatement(query)
	        ) {
	            pst.setInt(1, orderHistory.getOrderId());
	            pst.setInt(2, orderHistory.getUserId());

	            int i = pst.executeUpdate();
	            return i == 1;
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }

	    @Override
	    public boolean updateOrderHistory(OrderHistory orderHistory) {
	        String query = "UPDATE orderhistory SET orderId = ?, userId = ? WHERE orderHistoryId = ?";

	        try (
	            Connection con = ConnectionFactory.getConnection();
	            PreparedStatement pst = con.prepareStatement(query)
	        ) {
	            pst.setInt(1, orderHistory.getOrderId());
	            pst.setInt(2, orderHistory.getUserId());
	            pst.setInt(3, orderHistory.getOrderHistoryId());

	            int i = pst.executeUpdate();
	            return i == 1;
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }

	    @Override
	    public boolean deleteOrderHistory(int orderHistoryId) {
	        String query = "DELETE FROM orderhistory WHERE orderHistoryId = ?";

	        try (
	            Connection con = ConnectionFactory.getConnection();
	            PreparedStatement pst = con.prepareStatement(query)
	        ) {
	            pst.setInt(1, orderHistoryId);

	            int i = pst.executeUpdate();
	            return i == 1;
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
	
}
