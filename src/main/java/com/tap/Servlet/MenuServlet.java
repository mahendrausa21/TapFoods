package com.tap.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.model.Menu;
import com.tapDaoIMp.MenuDaoImp;

@WebServlet("/MenuServlet")

public class MenuServlet extends HttpServlet{
	
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
	int restaurantId = Integer.parseInt(req.getParameter( "restaurantId"));
	
	MenuDaoImp menuImp = new  MenuDaoImp();
	
	List<Menu> menu = menuImp.getMenusByRestaurantId(restaurantId);
	
	
		HttpSession session=	req.getSession();
	
	session.setAttribute("menu", menu);
	
	resp.sendRedirect("menu.jsp");
	
	
	
	
	
	}

}
