package com.tap.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LogOutServlet")
public class LogOutServlet extends HttpServlet {


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
		  HttpSession session = req.getSession(false); // Get session if exists, don't create new
	        if (session != null) {
	            session.invalidate(); // Destroy session
	        }
	        
	        // Redirect to login page after logout
	        resp.sendRedirect("login.jsp");
	
	
	
	}
	
}
