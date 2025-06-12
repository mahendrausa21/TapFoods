<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome | Food Delivery App</title>
    <link rel="stylesheet" href="css/index.css">
</head>
<body>

<nav class="navbar">
    <div class="logo">
        <img src="images/tapfoods_logo.png" alt="TapFoods Logo" class="logo-img"> <!-- Logo image -->
        TapFoods
    </div>
    <ul class="nav-links">
        <li><a href="login.jsp">Login</a></li>
        <li><a href="signup.jsp">Register</a></li>
    </ul>
</nav>

<div class="hero">
    <h1>Welcome to TapFoods</h1>
    <p>"Good food is the foundation of genuine happiness. Order fresh, eat fresh with TapFoods!"</p> <!-- Beautiful Quote -->
</div>

<div class="restaurant-container">
    <div class="restaurant-card" onclick="window.location.href='login.jsp'">
        <img src="images/bakery.avif" alt="Karachi Bakery">
        <h3>Karachi Bakery</h3>
    </div>
    <div class="restaurant-card" onclick="window.location.href='login.jsp'">
        <img src="images/Biryani.avif" alt="Paradise Biryani">
        <h3>Paradise Biryani</h3>
    </div>
    <div class="restaurant-card" onclick="window.location.href='login.jsp'">
        <img src="images/Margherita.jpeg" alt="Little Italy">
        <h3>Little Italy</h3>
    </div>
    <div class="restaurant-card" onclick="window.location.href='login.jsp'">
        <img src="images/pizzahut.jpeg" alt="Pizza Hut">
        <h3>Pizza Hut</h3>
    </div>
    <div class="restaurant-card" onclick="window.location.href='login.jsp'">
        <img src="images/Sai.avif" alt="Sai Ram Tiffins">
        <h3>Sai Ram Tiffins</h3>
    </div>
    <div class="restaurant-card" onclick="window.location.href='login.jsp'">
        <img src="images/Tandoori.jpeg" alt="Bawarchi Tandoori">
        <h3>Bawarchi Tandoori</h3>
    </div>
    <div class="restaurant-card" onclick="window.location.href='login.jsp'">
        <img src="images/Urban.jpeg" alt="Urban Asia">
        <h3>Urban Asia</h3>
    </div>
    <div class="restaurant-card" onclick="window.location.href='login.jsp'">
        <img src="images/Veggie.jpeg" alt="Minerva Coffee Shop">
        <h3>Minerva Coffee Shop</h3>
    </div>
</div>

</body>
</html>
