<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login | Food Delivery App</title>

<link rel="stylesheet" href="css/login.css">

</head>
<body>

<div class="card">
    <div class="card-header">User Login</div>
    <div class="card-body">
    
    
    
     <% 
            String errorMessage = (String) request.getAttribute("errorMessage");
            if (errorMessage != null) {
        %>
            <p style="color:red; text-align:center;"><%= errorMessage %></p>
        <% } %>
    
    
    
        <form action="LoginServlet" method="POST">
            <div class="form-group">
                <label>Email Address</label>
                <input type="email" name="email" placeholder="mahendra@gmail.com" required>
            </div>
            <div class="form-group">
                <label>Password</label>
                <input type="password" name="password" placeholder="mahendra@123" required>
            </div>
            <div class="text-center">
                <button type="submit" class="btn-primary">Login</button>
            </div>
            <div class="signup-link text-center">
                Don't have an account? <a href="signup.jsp">Sign Up</a>
            </div>
        </form>
    </div>
</div>

</body>
</html>
