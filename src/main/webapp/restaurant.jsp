<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.tap.model.Restaurant" %>
<%@ page import="com.tap.model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Explore Restaurants</title>


<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css" rel="stylesheet">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/restaurant.css"> 
</head>
<body>

<%
    HttpSession session1 = request.getSession(false);
    User user = (User) session1.getAttribute("user");
    String username = (user != null) ? user.getName() : "Guest";
%>

<!-- Bootstrap Navbar -->
<nav class="navbar navbar-expand-lg bg-dark navbar-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">TAPFOOD</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
      aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item d-flex align-items-center">
          <span class="nav-link text-white">
            <i class="bi bi-person-circle"></i> Welcome, <%= username %>!
          </span>
        </li>
        <li class="nav-item">
<form action="<%= request.getContextPath() %>/LogOutServlet" method="post" class="d-inline">

            <button type="submit" class="btn btn-outline-light btn-sm ms-2">Logout</button>
          </form>
        </li>
      </ul>
    </div>
  </div>
</nav>

<div class="container mt-4">
    <h1 class="text-center text-white mb-4">Explore Restaurants Near You</h1>

    <div class="row justify-content-center">
    <%
        List<Restaurant> restaurantList = (List<Restaurant>) session.getAttribute("restaurantList");
        if (restaurantList != null && !restaurantList.isEmpty()) {
            for (Restaurant rest : restaurantList) {
    %>
        <div class="col-md-4 mb-4 d-flex justify-content-center">
            <a href="MenuServlet?restaurantId=<%= rest.getRestaurantId() %>" class="card-link">
                <div class="custom-card">
                    <img src="images/<%= rest.getImagepath() %>" alt="Restaurant Image">
                    <div class="info">
                        <h2><%= rest.getName() %></h2>
                        <p><strong>Rating:</strong> <%= rest.getRating() %> ⭐</p>
                        <p><strong>ETA:</strong> <%= rest.getEta() %> mins</p>
                        <p><strong>Cuisine:</strong> <%= rest.getCuisineType() %></p>
                        <p><strong>Address:</strong> <%= rest.getAddress() %></p>
                    </div>
                </div>
            </a>
        </div>
    <%
            }
        } else {
    %>
        <p class="no-data">No restaurants available to display.</p>
    <%
        }
    %>
    </div>
</div>

<!-- Bootstrap JS Bundle CDN -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
