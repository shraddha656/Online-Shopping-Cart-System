<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.onlineshopping.model.Order, com.onlineshopping.model.OrderItem" %>
<%
    // ---- SESSION CHECK (ADDED) ----
   //HttpSession session = request.getSession(false);
    if (session == null || session.getAttribute("user") == null) {
        response.sendRedirect("userLogin.jsp");
        return;   // stop page execution
    }
%>
<!DOCTYPE html>
<html>
<head>
<title>My Orders</title>
<style>
body { font-family: Arial; background:#f8f9fa; padding:20px; }
.order-box {
    background:white; padding:15px; margin-bottom:20px;
    border-radius:8px; box-shadow:0 2px 6px rgba(0,0,0,0.1);
}
.item-row { margin-left:20px; }
</style>
</head>
<body>

<!-- 🔹 HOME BUTTON -->
<div style="text-align:right; margin-bottom:15px;">
    <a href="products" 
       style="padding:10px 20px; background:#007bff; color:white; 
              text-decoration:none; border-radius:8px;">
       🏠 Home
    </a>
</div>

<h2 style="text-align:center;">📦 My Orders</h2>

<%
List<Order> orders = (List<Order>) request.getAttribute("orderList");
if (orders != null && !orders.isEmpty()) {
    for (Order o : orders) {
%>

<div class="order-box">
    <h3>Order ID: <%= o.getOrderId() %></h3>
    <p>Total Amount: ₹<%= o.getTotalAmount() %></p>
    <p>Payment: <%= o.getPaymentType() %></p>

    <h4>Items:</h4>
    <% for (OrderItem item : o.getItems()) { %>
        <div class="item-row">
            Product ID: <%= item.getProductId() %> |
            Qty: <%= item.getQuantity() %> |
            Price: ₹<%= item.getPrice() %>
        </div>
    <% } %>
</div>

<% } } else { %>
<h3 style="text-align:center; color:gray;">No orders found</h3>
<% } %>

</body>
</html>
