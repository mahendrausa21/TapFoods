<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup | Food Delivery App</title>

<link rel="stylesheet" href="css/signup.css"> 

</head>
<body>

<div class="card">
    <div class="card-header">User Signup</div>
    <div class="card-body">
        <form action="SignupServlet" method="POST">
            <div class="form-group">
                <label>Full Name</label>
                <input type="text" name="name" placeholder="Mahendra" required>
            </div>
            <div class="form-group">
                <label>Email Address</label>
                <input type="email" name="email" placeholder="mahendra@gmail.com" required>
            </div>
            <div class="form-group">
                <label>Phone Number</label>
                <input type="tel" name="phone" placeholder="8639417027" required>
            </div>
            <div class="form-group">
                <label>Address</label>
                <input type="text" name="address" placeholder="RTC X road" required>
            </div>
            <div class="form-group">
                <label>Username</label>
                <input type="text" name="username" placeholder="mahendra123" required>
            </div>
            <div class="form-group">
                <label>Password</label>
                <input type="password" name="password" placeholder="Create password" required>
            </div>
            <div class="text-center">
                <button type="submit" class="btn-primary">Sign Up</button>
            </div>
            <div class="signup-link text-center">
                Already have an account? <a href="login.jsp">Login</a>
            </div>
        </form>
    </div>
</div>

</body>
</html>
