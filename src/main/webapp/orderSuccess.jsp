<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    


<%
    // ---- SESSION CHECK (ADDED) ----
   //HttpSession session = request.getSession(false);
    if (session == null || session.getAttribute("user") == null) {
        response.sendRedirect("userLogin.jsp");
        return;   // stop page execution
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background: #eef2f7;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .container {
        background: white;
        width: 450px;
        padding: 40px 50px;
        border-radius: 14px;
        box-shadow: 0 4px 12px rgba(0,0,0,0.12);
        text-align: center;
    }

    h2 {
        color: #2e7d32;
        margin-bottom: 15px;
        font-size: 26px;
    }

    h3 {
        color: #333;
        margin: 8px 0;
    }

    .btn {
        display: inline-block;
        background: #007bff;
        color: white;
        padding: 10px 20px;
        border-radius: 8px;
        text-decoration: none;
        font-size: 16px;
        margin: 12px 0;
    }

    .btn:hover {
        background: #0056b3;
    }

    .logout {
        background: #dc3545;
    }

    .logout:hover {
        background: #b02a37;
    }
</style>

</head>
<body>

<div class="container">

    <h2>🎉 Order Placed Successfully!</h2>

    <h3>Order ID: <%= request.getAttribute("orderId") %></h3>
    <h3>Total Amount: ₹<%= request.getAttribute("totalAmount") %></h3>

    <a href="products" class="btn">Continue Shopping</a>
    <br>
    <a href="logout" class="btn logout">Logout</a>

</div>

</body>
</html>