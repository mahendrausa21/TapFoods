<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.List,com.tap.model.Menu" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/menu.css">
</head>
<body>

<div class="container mt-4">
    <h2 class="text-center mb-4">Menu</h2>
    <div class="row">
        <%
            List<Menu> menuList = (List<Menu>) session.getAttribute("menu");
            if (menuList != null && !menuList.isEmpty()) {
                for (Menu m : menuList) {
        %>
        <div class="col-md-4 mb-4">
            <div class="card h-100">
                <img src="images/<%= m.getImagepath() %>" class="card-img-top" alt="Menu Image">
                <div class="card-body">
                    <h5 class="card-title"><%= m.getName() %></h5>
                    <p class="card-text">₹<%= m.getPrice() %></p>
                    <p class="card-text"><%= m.getDescription() %></p>
                    <p class="card-text">Rating: <%= m.getRating() %> ⭐</p>
                    <form action="AddToCartServlet" method="post">
                        <input type="hidden" name="itemId" value="<%= m.getMenuId() %>">
                        <input type="hidden" name="name" value="<%= m.getName() %>">
                        <input type="hidden" name="restaurantId" value="<%= m.getRestaurantId() %>">
                        <input type="hidden" name="price" value="<%= m.getPrice() %>">
                        <input type="hidden" name="imagePath" value="<%= m.getImagepath() %>"> <!-- Important: Passing imagePath to Servlet -->
                        <div class="mb-2">
                            <label>Quantity:</label>
                            <input type="number" name="quantity" value="1" min="1" class="form-control">
                        </div>
                        <button type="submit" class="btn btn-primary w-100">Add to Cart</button>
                    </form>
                </div>
            </div>
        </div>
        <%  }
            } else { %>
            <h2>No menu items available.</h2>
        <% } %>
    </div>
</div>

</body>
</html>
