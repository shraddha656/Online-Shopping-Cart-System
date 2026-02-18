<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.onlineshopping.model.CartItem" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Cart</title>
<style>
table {
    width: 85%;
    margin: auto;
    border-collapse: collapse;
}
th, td {
    padding: 12px;
    border-bottom: 1px solid #ddd;
    text-align: center;
}
img {
    width: 80px;
    height: 80px;
    object-fit: cover;
}
.btn {
    padding: 10px 20px;
    background: #007bff;
    color: white;
    border-radius: 8px;
    text-decoration: none;
}
.remove-btn {
    background: red;
}
</style>

</head>
<body>
<h2 style="text-align:center;">🛒 Your Cart</h2>

<% if (request.getAttribute("error") != null) { %>
    <p style="color:red; text-align:center; font-size:18px;">
        <%= request.getAttribute("error") %>
    </p>
<% } %>

<a href="products" class="btn" style="margin-left:10%;">⬅ Continue Shopping</a>

<table>
<tr>
<th>Image</th>
<th>Name</th>
<th>Price</th>
<th>Qty</th>
<th>Total</th>
<th>Action</th>
</tr>

<%
List<CartItem> cart = (List<CartItem>) request.getAttribute("cartItems");
double grandTotal = 0;

if (cart != null && !cart.isEmpty()) {

    for (CartItem item : cart) {
        grandTotal = grandTotal + item.getTotalPrice();
%>

<tr>
<td><img src="<%=item.getProduct().getImage()%>" /></td>
<td><%=item.getProduct().getName()%></td>
<td>₹<%=item.getProduct().getPrice()%></td>

<td>
<form action="updatequantity" method="post">
    <input type="hidden" name="id" value="<%=item.getProduct().getId()%>">
    <input type="number" min="1" name="quantity" value="<%=item.getQuantity()%>" />
    <button class="btn">Update</button>
</form>
</td>

<td>₹<%=item.getTotalPrice()%></td>

<td>
    <a class="btn remove-btn"
       href="removefromcart?id=<%=item.getProduct().getId()%>">Remove</a>
</td>
</tr>

<%
    }
} else {
%>

<tr>
<td colspan="6">Your cart is empty!</td>
</tr>

<%
}
%>

</table>

<h2 style="text-align:center;">Grand Total: ₹<%=grandTotal%></h2>

</body>

<div style="text-align:center; margin-top:20px;">
    <a href="address.jsp" class="btn" style="background:green;">Proceed to Checkout</a>
</div>


</html>