package com.tapDaoIMp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.Dao.OrderItemDao;
import com.tap.model.OrderItem;

public class OrderItemDaoImp  implements OrderItemDao{

	@Override
	public List<OrderItem> getAllOrderItems() {

		 String query = "SELECT * FROM orderitem";
	        List<OrderItem> list = new ArrayList<>();

	        try (
	            Connection con = ConnectionFactory.getConnection();
	            PreparedStatement pst = con.prepareStatement(query);
	            ResultSet res = pst.executeQuery()
	        ) {
	            while (res.next()) {
	                int orderItemId = res.getInt(1);
	                int userId = res.getInt(2);
	                int menuId = res.getInt(3);
	                String name = res.getString(4);
	                float rating = res.getFloat(5);
	                int quantity = res.getInt(6);
	                double price = res.getDouble(7);
	                int orderId = res.getInt(8);

	                OrderItem item = new OrderItem(orderItemId, userId, menuId, name, rating, quantity, price, orderId);
	                list.add(item);
	            }
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }

	        return list;
		
		
	}

	@Override
	public OrderItem getOrderItem(int orderItemId) {

		
		 String query = "SELECT * FROM orderitem WHERE orderItemId = ?";
	        OrderItem item = null;

	        try (
	            Connection con = ConnectionFactory.getConnection();
	            PreparedStatement pst = con.prepareStatement(query)
	        ) {
	            pst.setInt(1, orderItemId);
	            ResultSet res = pst.executeQuery();

	            if (res.next()) {
	                int userId = res.getInt(2);
	                int menuId = res.getInt(3);
	                String name = res.getString(4);
	                float rating = res.getFloat(5);
	                int quantity = res.getInt(6);
	                double price = res.getDouble(7);
	                int orderId = res.getInt(8);

	                item = new OrderItem(orderItemId, userId, menuId, name, rating, quantity, price, orderId);
	            }
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }

	        return item;
		
	}

	@Override
	public boolean insertOrderItem(OrderItem orderItem) {

        String query = "INSERT INTO orderitem (userId, menuId, name, rating, quantity, price, orderId) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement pst = con.prepareStatement(query)
        ) {
            pst.setInt(1,orderItem.getUserId());
            pst.setInt(2, orderItem.getMenuId());
            pst.setString(3, orderItem.getName());
            pst.setFloat(4, orderItem.getRating());
            pst.setInt(5, orderItem.getQuantity());
            pst.setDouble(6, orderItem.getPrice());
            pst.setInt(7, orderItem.getOrderId());

            int i = pst.executeUpdate();
            return i == 1;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return false;

		
		
	}

	@Override
	public boolean updateOrderItem(OrderItem orderItem) {
		
		
		 String query = "UPDATE orderitem SET userId=?, menuId=?, name=?, rating=?, quantity=?, price=?, orderId=? WHERE orderItemId=?";

	        try (
	            Connection con = ConnectionFactory.getConnection();
	            PreparedStatement pst = con.prepareStatement(query)
	        ) {
	            pst.setInt(1, orderItem.getUserId());
	            pst.setInt(2, orderItem.getMenuId());
	            pst.setString(3, orderItem.getName());
	            pst.setFloat(4, orderItem.getRating());
	            pst.setInt(5, orderItem.getQuantity());
	            pst.setDouble(6, orderItem.getPrice());
	            pst.setInt(7, orderItem.getOrderId());
	            pst.setInt(8, orderItem.getOrderItemId());

	            int i = pst.executeUpdate();
	            return i == 1;
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }

	        return false;

		
	}

	@Override
	public boolean deleteOrderItem(int orderItemId) {
			
		 String query = "DELETE FROM orderitem WHERE orderItemId = ?";

	        try (
	            Connection con = ConnectionFactory.getConnection();
	            PreparedStatement pst = con.prepareStatement(query)
	        ) {
	            pst.setInt(1, orderItemId);

	            int i = pst.executeUpdate();
	            return i == 1;
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }

	        return false;
	    }
	
	
	

}
