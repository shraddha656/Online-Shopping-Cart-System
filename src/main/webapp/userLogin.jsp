<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
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
        width: 360px;
        padding: 30px;
        border-radius: 14px;
        box-shadow: 0 4px 12px rgba(0,0,0,0.12);
    }

    h2 {
        text-align: center;
        color: #007bff;
        margin-bottom: 20px;
    }

    input[type=email],
    input[type=password] {
        width: 100%;
        padding: 10px;
        margin-top: 8px;
        margin-bottom: 18px;
        border: 1px solid #ccc;
        border-radius: 6px;
        font-size: 15px;
    }

    button {
        width: 100%;
        padding: 10px;
        background: #007bff;
        color: white;
        border: none;
        border-radius: 8px;
        font-size: 16px;
        cursor: pointer;
    }

    button:hover {
        background: #005dc1;
    }

    p {
        text-align: center;
        margin-top: 15px;
    }

    a {
        color: #007bff;
        text-decoration: none;
    }

    a:hover {
        text-decoration: underline;
    }

</style>

</head>
<body>

<div class="container">
    <h2>User Login</h2>

    <form action="login" method="post">
        Email:
        <input type="email" name="email" required>

        Password:
        <input type="password" name="password" required>

        <button type="submit">Login</button>
    </form>

    <p>New User? <a href="register.jsp">Register Here</a></p>
</div>

</body>
</html>