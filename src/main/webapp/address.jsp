<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>

<%
    // ---- SESSION CHECK (ADDED) ----
    // HttpSession session = request.getSession(false);
    if (session == null || session.getAttribute("user") == null) {
        response.sendRedirect("userLogin.jsp");
        return;   // stop page execution
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delivery Address</title>
</head>
<style>
    body {
        font-family: Arial, sans-serif;
        background: #f4f7fc;
        margin: 0;
        padding: 0;
    }

    h2 {
        text-align: center;
        margin-top: 30px;
        color: #333;
    }

    form {
        width: 400px;
        background: white;
        margin: 30px auto;
        padding: 25px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
    }

    input, textarea {
        width: 100%;
        padding: 10px;
        margin-top: 5px;
        margin-bottom: 20px;
        border: 1px solid #ccc;
        border-radius: 6px;
        font-size: 14px;
    }

    textarea {
        height: 80px;
        resize: none;
    }

    button {
        width: 100%;
        padding: 12px;
        background: #007bff;
        color: white;
        border: none;
        font-size: 16px;
        border-radius: 6px;
        cursor: pointer;
    }

    button:hover {
        background: #0056b3;
    }
</style>
<body>

<!-- 🔹 BACK TO CART BUTTON -->
<a href="cart" class="back-btn">⬅ Back to Cart</a>

    <h2>Add Your Delivery Address</h2>

<form action="saveaddress" method="post">

Full Name: <input type="text" name="fullname" required><br><br>
Mobile: <input type="text" name="mobile" required><br><br>
Address: <textarea name="address" required></textarea><br><br>
City: <input type="text" name="city" required><br><br>
Pincode: <input type="text" name="pincode" required><br><br>

<button type="submit">Save Address</button>

</form>
</body>
</html>
