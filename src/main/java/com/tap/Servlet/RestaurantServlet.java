package com.tap.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.model.Restaurant;
import com.tapDaoIMp.RestaurantDaoImp;


@WebServlet("/RestaurantServlet")
public class RestaurantServlet extends HttpServlet {


	
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
		RestaurantDaoImp restaurantimp = new RestaurantDaoImp();
		
		
		List<Restaurant> restaurantList = restaurantimp.getAll();
		
		
		HttpSession session = req.getSession(true);
		
		session.setAttribute("restaurantList",restaurantList );
		

		
		
		resp.sendRedirect("restaurant.jsp");
	
	}
	
	
	
	
	
	
	
	
	
	
}
