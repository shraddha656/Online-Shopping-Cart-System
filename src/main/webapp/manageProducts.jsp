<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Products</title>
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
        padding: 40px 60px;
        border-radius: 14px;
        box-shadow: 0 4px 12px rgba(0,0,0,0.1);
        text-align: center;
        width: 450px;
    }

    h2 {
        color: #333;
        margin-bottom: 30px;
    }

    ul {
        list-style: none;
        padding: 0;
    }

    ul li {
        margin: 18px 0;
    }

    a {
        display: inline-block;
        text-decoration: none;
        padding: 10px 18px;
        background: #007bff;
        color: white;
        border-radius: 8px;
        font-size: 16px;
        width: 70%;
    }

    a:hover {
        background: #0056b3;
    }

    .back-btn {
        background: #6c757d;
        margin-top: 20px;
    }

    .back-btn:hover {
        background: #5a6268;
    }
</style>

</head>
<body>

<div class="container">
    <h2>Product Management</h2>

    <ul>
        <li><a href="adminAddProduct.jsp">➕ Add New Product</a></li>
        <li><a href="adminProductsList">📦 View All Products</a></li>
        <li><a href="adminEditProduct">✏️ Update Product</a></li>
        <li><a href="adminDeleteSearch.jsp">🗑️ Delete Product</a></li>
    </ul>

    <a href="adminDashboard.jsp" class="back-btn">⬅ Back to Dashboard</a>
</div>

</body>
</html>