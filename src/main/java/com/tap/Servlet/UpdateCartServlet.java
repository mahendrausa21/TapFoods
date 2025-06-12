package com.tap.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.tap.model.Cart;
import com.tap.model.CartManager;

@WebServlet("/UpdateCartServlet")
public class UpdateCartServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        // Get itemId and quantity from request
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        // Get cart from session
        HttpSession session = request.getSession();
        CartManager cartManager = (CartManager) session.getAttribute("cart");

        if (cartManager != null) {
            cartManager.updateCartItemQuantity(itemId, quantity);
            session.setAttribute("cart", cartManager);
        }

        // Redirect back to cart.jsp
        response.sendRedirect("cart.jsp");
    }
}
