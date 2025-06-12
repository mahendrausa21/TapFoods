package com.tapDaoIMp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.Dao.MenuDao;
import com.tap.model.Menu;

public class MenuDaoImp implements MenuDao {

	@Override
	public List<Menu> getAll() {
		
		String query="select * from menu";
		List<Menu> list= new ArrayList<>();
		
		try (
			Connection con=ConnectionFactory.getConnection();
				Statement st=con.createStatement()) {
			
		 ResultSet res=	st.executeQuery(query);
		 
		 while(res.next()) {
			 
			     int	menuId =res.getInt(1);
				 String name =res.getString(2);
				 double price =res.getDouble(3);
				  String description =res.getString(4);
				  String imagepath =res.getString(5);
				  boolean isAvailable =res.getBoolean(6);
				  int restaurantId =res.getInt(7);
				  float rating =res.getFloat(8);
				  
				  Menu menu=new Menu(menuId, name, price, description, imagepath, isAvailable, restaurantId, rating);
			 list.add(menu);
		 }
			
		 
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
		
	}

	@Override
	public Menu getMenu(int menuId) {

		String query="select * from menu where menuId = ?";
		
		Menu menu=null;
		
		try (
				Connection con=ConnectionFactory.getConnection();
					PreparedStatement pst=con.prepareStatement(query)) {
			pst.setInt(1, menuId);	
			
			 ResultSet res=	pst.executeQuery();
			 
			 if(res.next()) {
				 
					 String name =res.getString(2);
					 double price =res.getDouble(3);
					  String description =res.getString(4);
					  String imagepath =res.getString(5);
					  boolean isAvailable =res.getBoolean(6);
					  int restaurantId =res.getInt(7);
					  float rating =res.getFloat(8);
					  
					   menu=new Menu(menuId, name, price, description, imagepath, isAvailable, restaurantId, rating);
				 
			 }
				
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	
	return menu;
	
	}
	
	
	@Override
	public List<Menu> getMenusByRestaurantId(int restaurantId) {
	    String query = "SELECT * FROM menu WHERE restaurantId = ?";
	    List<Menu> list = new ArrayList<>();
	    
	    try (
	        Connection con = ConnectionFactory.getConnection();
	        PreparedStatement pst = con.prepareStatement(query)) {
	        
	        pst.setInt(1, restaurantId);
	        ResultSet res = pst.executeQuery();
	        
	        while (res.next()) {
	            Menu menu = new Menu(
	                res.getInt(1),
	                res.getString(2),
	                res.getDouble(3),
	                res.getString(4),
	                res.getString(5),
	                res.getBoolean(6),
	                res.getInt(7),
	                res.getFloat(8)
	            );
	            list.add(menu);
	        }
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	    return list;
	}

	

	@Override
	public boolean insertMenu(Menu menu) {


		String query="Insert into menu( name, price, description, imagepath, isAvailable, restaurantId, rating) "
				+ "values(?,?,?,?,?,?,?)";
		
		
		try (
				Connection con=ConnectionFactory.getConnection();
					PreparedStatement pst=con.prepareStatement(query)) {
			   
			pst.setString(1,menu.getName() );
			pst.setDouble(2,menu.getPrice());
			pst.setString(3,menu.getDescription());
			pst.setString(4,menu.getImagepath() );
			pst.setBoolean(5,menu.isAvailable());
			pst.setInt(6,menu.getRestaurantId() );
			pst.setFloat(7,menu.getRating());
			
			 int i =	pst.executeUpdate();
			 
			 return i==1;
				
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	
		return false;
		
	}

	@Override
	public boolean updateMenu(Menu menu) {
		
		
		 String query = "UPDATE menu SET name = ?, price = ?, description = ?, imagepath = ?, "
                 + "isAvailable = ?, restaurantId = ?, rating = ? WHERE menuId = ?";

    try (
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = con.prepareStatement(query)
    ) {
        pst.setString(1, menu.getName());
        pst.setDouble(2, menu.getPrice());
        pst.setString(3, menu.getDescription());
        pst.setString(4, menu.getImagepath());
        pst.setBoolean(5, menu.isAvailable());
        pst.setInt(6, menu.getRestaurantId());
        pst.setFloat(7, menu.getRating());
        pst.setInt(8, menu.getMenuId()); 

        int i = pst.executeUpdate();

        return i == 1; 

    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }

    return false;
    
    
	}

	@Override
	public boolean deleteMenu(int menuId) {

		String query="delete from menu where menuId = ?";
		
		try (
				Connection con=ConnectionFactory.getConnection();
					PreparedStatement pst=con.prepareStatement(query)) {
			pst.setInt(1, menuId);
			
			int i = pst.executeUpdate();
			return i==1;
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}

	

}
