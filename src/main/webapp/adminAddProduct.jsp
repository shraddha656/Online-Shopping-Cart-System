<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background: #f5f7fa;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .container {
        background: white;
        padding: 30px 40px;
        border-radius: 10px;
        box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        width: 380px;
    }

    h2 {
        text-align: center;
        color: #333;
        margin-bottom: 20px;
    }

    input, textarea {
        width: 100%;
        padding: 10px;
        margin: 8px 0 15px 0;
        border: 1px solid #ccc;
        border-radius: 6px;
    }

    button {
        width: 100%;
        padding: 12px;
        background: #007bff;
        color: white;
        border: none;
        border-radius: 6px;
        cursor: pointer;
        font-size: 16px;
    }

    button:hover {
        background: #0056b3;
    }
</style>

</head>
<body>
	<div class="container">
    <h2>Add New Product</h2>

    <form action="adminAddProduct" method="post">
        Name: 
        <input type="text" name="name" required>

        Description: 
        <input type="text" name="description" required>

        Price: 
        <input type="number" name="price" step="0.01" required>

        Category: 
        <input type="text" name="category" required>

        Quantity: 
        <input type="number" name="quantity" required>

        Image URL: 
        <input type="text" name="image" required>

        <button type="submit">Add Product</button>
    </form>
</div>

</body>
</html>