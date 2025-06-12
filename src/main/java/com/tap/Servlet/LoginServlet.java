package com.tap.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.model.User;
import com.tapDaoIMp.UserDaoImp;


@WebServlet("/LoginServlet")

public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
	
	String email= req.getParameter("email");
	String password= req.getParameter("password");
	
	
	  
    UserDaoImp userDao = new UserDaoImp();
    User user = userDao.validateUser(email, password);
    
    if(user != null) {
        HttpSession session = req.getSession();
        session.setAttribute("user", user);
        session.setAttribute("userId", user.getUserId()); // IMPORTANT LINE to fix the error
        resp.sendRedirect("RestaurantServlet");
    }
 else {
     
        req.setAttribute("errorMessage", "Invalid Email or Password!");
        RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
        rd.forward(req, resp);
    }
	
	
	
	
	
	
	}
	
}
