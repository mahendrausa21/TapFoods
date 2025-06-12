package com.tapDaoIMp;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.Dao.RestaurantDao;
import com.tap.model.Restaurant;


public class RestaurantDaoImp implements RestaurantDao {

	@Override
	public List<Restaurant> getAll() {
		
		List<Restaurant> list= new ArrayList<>();
		
		String query="select * from restaurant";
		
		try (
			Connection con=ConnectionFactory.getConnection();
			
			Statement st=con.createStatement();){
			
			
			ResultSet res=st.executeQuery(query);
			
			while(res.next()) {
				int restaurantId =res.getInt(1);
				 String   name =res.getString(2);
				 String	imagepath =res.getString(3);
				 float rating = res.getFloat(4);
				 int 	eta = res.getInt(5);
				String cuisineType = res.getString(6);
			String 	address =res.getString(7);
			boolean	isActive = res.getBoolean(8); 
			int	restOwnerId = res.getInt(9);
			
			Restaurant rest= new Restaurant(restaurantId, name, imagepath, rating, eta, cuisineType, address, isActive, restOwnerId);

			
			
				list.add(rest);
			}
				
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	
		
	}

	@Override
	public Restaurant getRestaurant(int restaurantId) {
		
		Restaurant rest=null;
		String query="select * from restaurant where  restaurantId = ?";
		
		try (
			Connection con=ConnectionFactory.getConnection();
				PreparedStatement pstst= con.prepareStatement(query)){
			
			pstst.setInt(1, restaurantId);
			ResultSet res = pstst.executeQuery();
			
				if(res.next()) {
				 String   name =res.getString(2);
				 String	imagepath =res.getString(3);
				 float rating = res.getFloat(4);
				 int 	eta = res.getInt(5);
				String cuisineType = res.getString(6);
			String 	address =res.getString(7);
			boolean	isActive = res.getBoolean(8); 
			int	restOwnerId = res.getInt(9);
			
			
			
			 rest= new Restaurant(restaurantId, name, imagepath, rating, eta, cuisineType, address, isActive, restOwnerId);
			
				
			}
	
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return rest;
				
	}

	@Override
	public boolean insertRestaurant(Restaurant res) {

		  String query = "INSERT INTO restaurant (name, imagepath, rating, eta, cuisineType, address, isActive, restOwnerId) " +
                  "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

   try (
       Connection con = ConnectionFactory.getConnection();
       PreparedStatement pst = con.prepareStatement(query))
    {
	   System.out.println("Before setting parameters");
       pst.setString(1, res.getName());
       pst.setString(2, res.getImagepath());
       pst.setFloat(3, res.getRating());
       pst.setInt(4, res.getEta());
       pst.setString(5, res.getCuisineType());
       pst.setString(6, res.getAddress());
       pst.setBoolean(7, res.isActive());
       pst.setInt(8, res.getRestOwnerId());
       System.out.println("Parameters set, executing update...");

       int rows = pst.executeUpdate();
       System.out.println("Rows affected: " + rows);
       return rows > 0;

   } catch (ClassNotFoundException | SQLException e) {
       e.printStackTrace();
   }

   return false;
	
	}

	@Override
	public boolean updateRestaurant(Restaurant res) {
	    String query = "UPDATE restaurant SET name = ?, imagepath = ?, rating = ?, eta = ?, cuisineType = ?, address = ?, isActive = ?, restOwnerId = ? WHERE restaurantId = ?";

	    try (
	        Connection con = ConnectionFactory.getConnection();
	        PreparedStatement pst = con.prepareStatement(query);
	    ) {
	        pst.setString(1, res.getName());
	        pst.setString(2, res.getImagepath());
	        pst.setFloat(3, res.getRating());
	        pst.setInt(4, res.getEta());
	        pst.setString(5, res.getCuisineType());
	        pst.setString(6, res.getAddress());
	        pst.setBoolean(7, res.isActive());
	        pst.setInt(8, res.getRestOwnerId());
	        pst.setInt(9, res.getRestaurantId());

	        int rowsUpdated = pst.executeUpdate();
	        return rowsUpdated > 0;

	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }

	    return false;

	}

	@Override
	public boolean deleteRestaurant(int restaurantId) {
		 String query = "DELETE FROM restaurant WHERE restaurantId = ?";

		    try (
		        Connection con = ConnectionFactory.getConnection();
		        PreparedStatement pst = con.prepareStatement(query);
		    ) {
		        pst.setInt(1, restaurantId);
		        int rowsDeleted = pst.executeUpdate();
		        return rowsDeleted > 0;

		    } catch (ClassNotFoundException | SQLException e) {
		        e.printStackTrace();
		    }

		    return false;
	}

}
