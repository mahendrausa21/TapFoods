package com.tap.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.model.Cart;
import com.tap.model.CartManager;


@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {

	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		  int itemId = Integer.parseInt(request.getParameter("itemId"));
		    int restId = Integer.parseInt(request.getParameter("restaurantId"));
		    String name = request.getParameter("name");
		    double price = Double.parseDouble(request.getParameter("price"));
		    int quantity = Integer.parseInt(request.getParameter("quantity"));
		    String imagePath = request.getParameter("imagePath"); // Important
		    String ratingParam = request.getParameter("rating");
	        float rating = 0.0f;
	        if (ratingParam != null && !ratingParam.trim().isEmpty()) {
	            rating = Float.parseFloat(ratingParam);
	        }

		    HttpSession session = request.getSession();
		    CartManager cartManager = (CartManager) session.getAttribute("cart");

		    if (cartManager == null) {
		        cartManager = new CartManager();
		        session.setAttribute("cart", cartManager);
		    }

		    // Pass imagePath to Cart constructor
		    Cart cartItem = new Cart(itemId, restId, name, price, quantity, imagePath,rating);
		    cartManager.addCartItem(cartItem);

		    response.sendRedirect("cart.jsp");
	    }
	
	
	}

	


