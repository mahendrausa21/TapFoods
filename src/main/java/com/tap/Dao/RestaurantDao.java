package com.tap.Dao;
import java.util.List;

import com.tap.model.*;

public interface RestaurantDao {

	
	
	List<Restaurant> getAll();
	
	Restaurant getRestaurant(int restaurantId);
	
	boolean insertRestaurant(Restaurant res);
	
	boolean updateRestaurant(Restaurant res);
	
	boolean deleteRestaurant(int restaurantId);
	
	
	
}
