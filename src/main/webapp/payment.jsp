<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>

<%
    // ---- SESSION CHECK (ADDED) ----
    // HttpSession session = request.getSession(false);
    if (session == null || session.getAttribute("user") == null) {
        response.sendRedirect("userLogin.jsp");
        return;   // stop page execution
    }
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select Payment Method</title>
<style>
.container {
    width: 40%;
    margin: 50px auto;
    padding: 25px;
    background: #f8f9fa;
    border-radius: 10px;
    box-shadow: 0 0 8px rgba(0,0,0,0.2);
}
h2 { text-align:center; }
.btn {
    padding: 10px 20px;
    background: #007bff;
    color: #fff;
    border-radius: 8px;
    border: none;
}
</style>

</head>
<body>
	<body>

<div class="container">
<h2>💳 Choose Payment Method</h2>

<form action="payment" method="post">

    <input type="radio" name="method" value="COD" required> Cash on Delivery <br><br>
    <input type="radio" name="method" value="UPI"> UPI <br><br>
    <input type="radio" name="method" value="CARD"> Credit / Debit Card <br><br>

    <br>
    <button type="submit" class="btn">Continue</button>

</form>

</div>

</body>
</body>
</html>