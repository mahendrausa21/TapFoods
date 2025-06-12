<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*, com.tap.model.CartManager, com.tap.model.Cart" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Cart | Food Delivery App</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <h2 class="text-center mb-4">Your Cart</h2>
    <%
        CartManager cartManager = (CartManager) session.getAttribute("cart");
        if (cartManager != null && !cartManager.getCartItems().isEmpty()) {
            Map<Integer, Cart> cartItems = cartManager.getCartItems();

            // Fetch restaurantId from first cart item
            int restaurantId = 0;
            if (!cartItems.isEmpty()) {
                restaurantId = cartItems.values().iterator().next().getRestaurantId();
            }
    %>
    <table class="table table-bordered">
        <thead class="table-dark">
            <tr>
                <th>Item Image</th>
                <th>Name</th>
                <th>Price (₹)</th>
                <th>Quantity</th>
                <th>Total Price (₹)</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
        <%
            for (Cart item : cartItems.values()) {
        %>
            <tr>
            
            
                <td><img src="images/<%= item.getImagePath() %>" alt="Item Image" style="width: 80px; height: 80px;">
</td>
                <td><%= item.getName() %></td>
                <td><%= item.getPrice() %></td>
                <td>
                    <form action="UpdateCartServlet" method="post" class="d-flex">
                        <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                        <input type="number" name="quantity" value="<%= item.getQuantity() %>" min="1" class="form-control w-50 me-2">
                        <button type="submit" class="btn btn-sm btn-warning">Update</button>
                    </form>
                </td>
                <td><%= item.getPrice() * item.getQuantity() %></td>
                <td>
                    <form action="RemoveCartServlet" method="post">
                        <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                        <button type="submit" class="btn btn-sm btn-danger">Remove</button>
                    </form>
                </td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>

    <div class="d-flex justify-content-between">
        <!-- Now passing restaurantId properly -->
        <a href="MenuServlet?restaurantId=<%= restaurantId %>" class="btn btn-primary">Add More Items</a>

        <a href="checkout.jsp" class="btn btn-success">Proceed to Checkout</a>
    </div>

   <% 
    } else { 
%>
    <h4 class="text-center text-muted">Your cart is empty.</h4>
    <div class="text-center mt-3">
        <a href="RestaurantServlet" class="btn btn-primary">Go to Restaurants</a>
    </div>
<% } %>

</div>

</body>
</html>
