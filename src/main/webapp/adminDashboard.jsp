<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="jakarta.servlet.http.HttpSession" %>

<%
    HttpSession ss = request.getSession(false);

    if (ss == null || ss.getAttribute("admin") == null) {
        response.sendRedirect("adminLogin.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background: #eef2f5;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .container {
        background: white;
        padding: 40px 50px;
        border-radius: 12px;
        box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        width: 350px;
        text-align: center;
    }

    h2 {
        margin-bottom: 25px;
        font-size: 26px;
        color: #333;
    }

    a {
        display: block;
        background: #007bff;
        color: white;
        padding: 12px;
        text-decoration: none;
        border-radius: 8px;
        margin: 12px 0;
        font-size: 16px;
    }

    a:hover {
        background: #0056b3;
    }

    .logout {
        background: #dc3545;
    }

    .logout:hover {
        background: #a71d2a;
    }
</style>

</head>
<body>

<div class="container">
    <h2>Admin Dashboard</h2>

    <a href="adminProductsList">Manage Products</a>
    <a href="adminUsers">View Users</a>
    <a href="adminOrders">View Orders</a>
    <a href="logout" class="logout">Logout</a>
</div>

</body>
</html>