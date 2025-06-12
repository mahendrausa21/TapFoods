package com.tap.Servlet;

import com.tapDaoIMp.OrderDaoImp;
import com.tapDaoIMp.OrderHistoryDaoImp;
import com.tapDaoIMp.OrderItemDaoImp;
import com.tap.model.Cart;
import com.tap.model.Order;
import com.tap.model.Order.ModeOfPayment;
import com.tap.model.Order.Status;
import com.tap.model.OrderHistory;
import com.tap.model.OrderItem;
import com.tap.model.CartManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        CartManager cartManager = (CartManager) session.getAttribute("cart");
        Integer userId = (Integer) session.getAttribute("userId");
        String paymentModeStr = request.getParameter("paymentMode");

        if (cartManager == null || cartManager.getCartItems().isEmpty()) {
            response.sendRedirect("cart.jsp");
            return;
        }

        ModeOfPayment paymentMode = ModeOfPayment.valueOf(paymentModeStr.toLowerCase());
        double totalAmount = cartManager.calculateTotal();
        int restaurantId = cartManager.getCartItems().values().iterator().next().getRestaurantId();

        OrderDaoImp orderDao = new OrderDaoImp();
        Order order = new Order(0, restaurantId, userId, totalAmount, paymentMode, Status.confirmed);

        boolean orderInserted = orderDao.insertOrder(order);

        if (!orderInserted) {
            response.getWriter().write("Failed to place order.");
            return;
        }

        int orderId = orderDao.getLatestOrderIdByUser(userId); // implement this in DAO

        OrderHistoryDaoImp orderHistoryDao = new OrderHistoryDaoImp();
        orderHistoryDao.insertOrderHistory(new OrderHistory(0, orderId, userId));

        OrderItemDaoImp orderItemDao = new OrderItemDaoImp();
        for (Map.Entry<Integer, Cart> entry : cartManager.getCartItems().entrySet()) {
            Cart item = entry.getValue();
            OrderItem orderItem = new OrderItem(0, userId, item.getItemId(), item.getName(), item.getRating(),
                                                item.getQuantity(), item.getPrice(), orderId);
            orderItemDao.insertOrderItem(orderItem);
            
            
        }

        request.setAttribute("orderedItems", cartManager.getCartItems().values()); // send items
        request.setAttribute("totalAmount", cartManager.calculateTotal()); // send total amount
        request.setAttribute("orderId", orderId); // send orderId

        RequestDispatcher rd = request.getRequestDispatcher("orderConfirmation.jsp");
        rd.forward(request, response);

    }
}
