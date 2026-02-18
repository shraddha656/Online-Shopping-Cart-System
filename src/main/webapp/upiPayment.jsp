<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UPI Payment</title>
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
        width: 380px;
        padding: 30px;
        border-radius: 14px;
        box-shadow: 0 4px 12px rgba(0,0,0,0.12);
    }

    h2 {
        text-align: center;
        color: #007bff;
    }

    input[type=text] {
        width: 100%;
        padding: 10px;
        margin-top: 10px;
        margin-bottom: 20px;
        border: 1px solid #ccc;
        border-radius: 6px;
        font-size: 15px;
    }

    button {
        width: 100%;
        padding: 10px;
        background: #0c9c31;
        color: white;
        border: none;
        border-radius: 8px;
        font-size: 16px;
        cursor: pointer;
    }

    button:hover {
        background: #087327;
    }

</style>

</head>
<body>

<div class="container">
    <h2>UPI Payment</h2>

    <form action="upiPayment" method="post">

        <label>Enter UPI ID:</label>
        <input type="text" name="upiId" placeholder="example@upi" required>

        <button type="submit">Pay Now</button>
    </form>
</div>

</body>
</html>