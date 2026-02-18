<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Deleted</title>
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

    .box {
        background: white;
        padding: 40px 50px;
        border-radius: 12px;
        text-align: center;
        width: 380px;
        box-shadow: 0 4px 10px rgba(0,0,0,0.1);
    }

    h2 {
        color: green;
        margin-bottom: 25px;
    }

    a {
        display: inline-block;
        background: #007bff;
        color: white;
        text-decoration: none;
        padding: 10px 20px;
        border-radius: 8px;
        font-size: 16px;
    }

    a:hover {
        background: #0056b3;
    }
</style>

</head>
<body>

<div class="box">
    <h2>Product deleted successfully!</h2>
    <a href="adminProductsList">Back to Product List</a>
</div>

</body>
</html>