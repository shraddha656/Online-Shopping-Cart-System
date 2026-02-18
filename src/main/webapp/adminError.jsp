<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>

<style>
body {
    font-family: Arial, sans-serif;
    background: #ffe6e6;
    text-align: center;
    padding-top: 80px;
}

.error-box {
    background: #ffcccc;
    width: 350px;
    margin: auto;
    padding: 25px;
    border-radius: 10px;
    border: 2px solid red;
}

button {
    padding: 10px 20px;
    background: #007bff;
    border: none;
    color: white;
    border-radius: 8px;
    cursor: pointer;
    font-size: 16px;
}

button:hover {
    background: #0056b3;
}

a {
    color: white;
    text-decoration: none;
}

</style>
</head>
<body>
<div class="error-box">
    <h2>❌ Error Updating Product</h2>
    <p>Something went wrong! Please try again.</p>

    <br>
    <button><a href="adminDashboard.jsp">Back to Dashboard</a></button>
</div>

</body>
</html>