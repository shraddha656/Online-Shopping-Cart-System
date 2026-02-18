<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Updated</title>

<style>
body {
    font-family: Arial, sans-serif;
    background: #f2f2f2;
    text-align: center;
    padding-top: 80px;
}

.box {
    background: white;
    width: 350px;
    margin: auto;
    padding: 25px;
    border-radius: 10px;
    box-shadow: 0 0 12px rgba(0,0,0,0.2);
}

button {
    padding: 10px 20px;
    background: #28a745;
    border: none;
    color: white;
    border-radius: 8px;
    cursor: pointer;
    font-size: 16px;
}

button:hover {
    background: #218838;
}

a {
    text-decoration: none;
    color: white;
}

</style>
</head>
<body>
	<div class="box">
    <h2>✅ Product Updated Successfully!</h2>

    <br>
    <button><a href="adminDashboard.jsp">Back to Dashboard</a></button>
    <br><br>
    <button><a href="adminProductsList">Manage Products</a></button>
</div>
</body>
</html>