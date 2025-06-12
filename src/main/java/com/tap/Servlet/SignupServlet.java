package com.tap.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.model.User;
import com.tapDaoIMp.UserDaoImp;


@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
		   String name = req.getParameter("name");
	        String email = req.getParameter("email");
	        String phoneStr = req.getParameter("phone");
	        String address = req.getParameter("address");  // Now reading address too
	        String username = req.getParameter("username");
	        String password = req.getParameter("password");

	        // Parse phone number
	        long phoneNo = 0;
	        try {
	            phoneNo = Long.parseLong(phoneStr);
	        } catch (NumberFormatException e) {
	            e.printStackTrace(); // Invalid phone number handling
	        }

	        // Default Role assignment
	        User.Role role = User.Role.customer; // Assuming new user is always a USER

	        // Create User Object
	        User user = new User();
	        user.setName(name);
	        user.setEmail(email);
	        user.setPhoneNo(phoneNo);
	        user.setAddress(address);
	        user.setUsername(username);
	        user.setPassword(password);
	        user.setRole(role);

	        // Insert into DB via DAO
	        UserDaoImp userDao = new UserDaoImp();
	        boolean success = userDao.insertUser(user);

	        if (success) {
	            // Success: Redirect to login page
	            resp.sendRedirect("login.jsp");
	        } else {
	            // Failure: Redirect back to signup with error flag
	            resp.sendRedirect("signup.jsp?error=1");
	        }
	
	}
	
	

}
