package com.tap.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.tap.model.CartManager;

@WebServlet("/RemoveCartServlet")
public class RemoveCartServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        // Get itemId to remove
        int itemId = Integer.parseInt(request.getParameter("itemId"));

        // Get cart from session
        HttpSession session = request.getSession();
        CartManager cartManager = (CartManager) session.getAttribute("cart");

        if (cartManager != null) {
            cartManager.removeCartItem(itemId);
            session.setAttribute("cart", cartManager);
        }

        // Redirect back to cart.jsp
        response.sendRedirect("cart.jsp");
    }
}
