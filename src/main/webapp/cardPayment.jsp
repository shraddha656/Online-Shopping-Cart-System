<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Card Payment</title>
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
        background: #fff;
        padding: 35px 45px;
        border-radius: 12px;
        width: 380px;
        text-align: center;
        box-shadow: 0 4px 12px rgba(0,0,0,0.1);
    }

    h2 {
        margin-bottom: 25px;
        color: #333;
    }

    input[type="text"],
    input[type="password"],
    input[type="month"] {
        width: 90%;
        padding: 10px;
        margin-bottom: 15px;
        border-radius: 6px;
        border: 1px solid #aaa;
    }

    button {
        background: #007bff;
        color: white;
        border: none;
        padding: 12px 20px;
        font-size: 16px;
        border-radius: 8px;
        cursor: pointer;
        width: 100%;
    }

    button:hover {
        background: #0056b3;
    }
</style>

</head>

<body>

<div class="box">
    <h2>Card Payment</h2>

    <form action="cardpayment" method="post">

        <input type="text" name="cardNo" placeholder="Card Number" required><br>

        <input type="month" name="expiry" required><br>

        <input type="password" name="cvv" placeholder="CVV" required><br>

        <button type="submit">Pay Now</button>
    </form>
</div>

</body>
</html>