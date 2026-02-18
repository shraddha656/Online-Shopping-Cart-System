<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
</head>
<style>
body {
    font-family: Arial, sans-serif;
    background: #f2f2f2;
    padding: 0;
    margin: 0;
}
.login-box {
    width: 350px;
    background: white;
    padding: 25px;
    margin: 100px auto;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0,0,0,0.2);
}
h2 {
    text-align: center;
    margin-bottom: 20px;
}
input {
    width: 100%;
    padding: 10px;
    margin: 10px 0;
    border: 1px solid #ccc;
    border-radius: 5px;
}
button {
    width: 100%;
    padding: 10px;
    background: #007bff;
    border: none;
    color: white;
    font-size: 16px;
    border-radius: 5px;
    cursor: pointer;
}
button:hover {
    background: #0056b3;
}
p {
    text-align: center;
}
</style>
<body>
<div class="login-box">
    <h2>Admin Login</h2>

    
    <form action="adminLogin" method="post"> <!-- Submit to LoginServlet of admin-->

        <label>Email:</label>
        <input type="email" name="email" required>

        <label>Password:</label>
        <input type="password" name="password" required>

        <button type="submit">Login</button>
    </form>

    <p><a href="chooseUser.jsp">← Back</a></p>
</div>

</body>
</html>