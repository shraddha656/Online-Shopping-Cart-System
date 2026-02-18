<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.onlineshopping.model.Products" %>
<%
Products p = (Products) request.getAttribute("product");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Product</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background: #eef2f7;
        padding: 40px;
        display: flex;
        justify-content: center;
    }

    .container {
        width: 500px;
        background: white;
        padding: 30px;
        border-radius: 12px;
        box-shadow: 0px 5px 15px rgba(0,0,0,0.15);
    }

    h2 {
        text-align: center;
        color: #007bff;
        margin-bottom: 20px;
    }

    input[type=text],
    input[type=number],
    textarea {
        width: 100%;
        padding: 10px;
        border: 1px solid #aaa;
        border-radius: 6px;
        margin-bottom: 15px;
        font-size: 15px;
    }

    textarea {
        height: 80px;
        resize: none;
    }

    button {
        width: 100%;
        padding: 12px;
        background: #28a745;
        color: white;
        border: none;
        border-radius: 8px;
        cursor: pointer;
        font-size: 16px;
    }

    button:hover {
        background: #218838;
    }

    a {
        display: block;
        margin-top: 15px;
        text-align: center;
        color: #007bff;
        text-decoration: none;
        font-size: 15px;
    }

    a:hover {
        text-decoration: underline;
    }
</style>

</head>
<body>

<div class="container">

<h2>Edit Product</h2>

<form action="adminUpdateProduct" method="post">

    <input type="hidden" name="id" value="<%=p.getId()%>">

    Name:
    <input type="text" name="name" value="<%=p.getName()%>" required>

    Description:
    <textarea name="description" required><%=p.getDescription()%></textarea>

    Price:
    <input type="number" step="0.01" name="price" value="<%=p.getPrice()%>" required>

    Category:
    <input type="text" name="category" value="<%=p.getCategory()%>" required>

    Quantity:
    <input type="number" name="quantity" value="<%=p.getQuantity()%>" required>

    Image URL:
    <input type="text" name="image" value="<%=p.getImage()%>" required>

    <button type="submit">Update Product</button>
</form>

<a href="adminProductsList">⬅ Back to Product List</a>

</div>

</body>
</html>