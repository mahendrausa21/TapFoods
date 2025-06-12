<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.tap.model.Cart" %>
<%@ page import="com.tap.model.CartManager" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Confirmation</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding: 20px;
        }
        .confirmation-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 12px;
            max-width: 600px;
            margin: 0 auto;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .confirmation-container h2 {
            color: #27ae60;
        }
        .item {
            border-bottom: 1px solid #ddd;
            padding: 10px 0;
            display: flex;
            justify-content: space-between;
        }
        .total {
            font-weight: bold;
            font-size: 18px;
            margin-top: 20px;
            text-align: right;
        }
    </style>
</head>
<body>

<div class="confirmation-container">
    <h2>Thank You! Your Order is Confirmed 🎉</h2>
<p>Your order ID is: <strong><%= request.getAttribute("orderId") %></strong></p>


    <h3>Ordered Items:</h3>
    <%
        CartManager cartManager = (CartManager) session.getAttribute("cart");
        if (cartManager != null && !cartManager.getCartItems().isEmpty()) {
            Map<Integer, Cart> cartItems = cartManager.getCartItems();
            for (Cart item : cartItems.values()) {
    %>
        <div class="item">
            <span><%= item.getName() %> (x<%= item.getQuantity() %>)</span>
            <span>₹<%= item.getPrice() * item.getQuantity() %></span>
        </div>
    <%
            }
        } else {
    %>
        <p>No items found in your order.</p>
    <%
        }
    %>

    <div class="total">
        Total Paid: ₹<%= (cartManager != null) ? cartManager.calculateTotal() : "0.00" %>
    </div>
</div>

</body>
</html>
