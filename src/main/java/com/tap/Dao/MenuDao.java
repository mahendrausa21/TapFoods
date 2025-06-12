	package com.tap.Dao;
	
	import java.util.List;
	
	import com.tap.model.Menu;
	
	public interface MenuDao {
	
		
		List<Menu> getAll();
		
		Menu getMenu(int menuId);
		
		List<Menu> getMenusByRestaurantId(int restaurantId);

		
		boolean insertMenu(Menu menu);
		
		boolean updateMenu(Menu menu);
		
		boolean deleteMenu(int menuId);
		
		
		
	}
