<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*, com.tap.model.CartManager, com.tap.model.Cart" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout | Food Delivery App</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <h2 class="text-center mb-4">Checkout</h2>

    <form action="CheckoutServlet" method="post">
        <div class="mb-3">
            <label for="paymentMode" class="form-label">Select Payment Mode:</label>
            <select name="paymentMode" id="paymentMode" class="form-select" required>
                <option value="UPI">upi</option>
                <option value="CreditCard">Credit Card</option>
                <option value="DebitCard">Debit Card</option>
                <option value="Cash">Cash on Delivery</option>
            </select>
        </div>
        <button type="submit" class="btn btn-success w-100">Confirm Order</button>
    </form>
</div>

</body>
</html>
