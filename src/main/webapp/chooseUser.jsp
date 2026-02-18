<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Choose Role</title>

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
        text-align: center;
        background: white;
        padding: 40px 60px;
        border-radius: 14px;
        box-shadow: 0 4px 12px rgba(0,0,0,0.1);
    }

    h2 {
        margin-bottom: 30px;
        color: #333;
    }

    a {
        display: block;
        margin: 10px 0;
        padding: 12px 20px;
        background: #007bff;
        color: white;
        text-decoration: none;
        font-size: 16px;
        border-radius: 8px;
        width: 200px;
        margin-left: auto;
        margin-right: auto;
    }

    a:hover {
        background: #0056b3;
    }
</style>

</head>
<body>

<div class="container">
    <h2>Who are you?</h2>

    <a href="userLogin.jsp">User</a>
    <a href="adminLogin.jsp">Admin</a>
</div>

</body>
</html>