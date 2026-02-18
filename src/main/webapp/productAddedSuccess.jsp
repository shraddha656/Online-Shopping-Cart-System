<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Added</title>
</head>
<style>
body {
    font-family: Arial;
    background: #f2f2f2;
    text-align: center;
    padding-top: 50px;
}
.container {
    background: white;
    width: 40%;
    margin: auto;
    padding: 30px;
    border-radius: 10px;
    box-shadow: 0 2px 6px rgba(0,0,0,0.2);
}
.btn {
    display: inline-block;
    padding: 10px 20px;
    background: #007bff;
    color: white;
    margin: 10px;
    text-decoration: none;
    border-radius: 6px;
}
.btn:hover {
    background: #0056b3;
}
</style>
<body>
<div class="container">
    <h2>✔ Product Added Successfully!</h2>
    <p>Your product has been saved to the database.</p>

    <a class="btn" href="adminDashboard.jsp">Back to Dashboard</a>
    <a class="btn" href="adminProductsList">View All Products</a>
</div>
</body>
</html>