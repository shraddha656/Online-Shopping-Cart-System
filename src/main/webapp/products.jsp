<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.onlineshopping.model.Products" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shop Products</title>
<style>
body {
  font-family: Arial, sans-serif;
  background: #f8f9fa;
  margin: 0; padding: 0;
}
h2 { text-align: center; margin-top: 20px; }
.container {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
  gap: 20px;
  padding: 20px;
}
.card {
  background: white;
  border-radius: 12px;
  box-shadow: 0 2px 6px rgba(0,0,0,0.1);
  overflow: hidden;
  transition: transform 0.2s ease;
}
.card:hover { transform: scale(1.03); }
.card img {
  width: 100%;
  height: 220px;
  object-fit: cover;
}
.card-content {
  padding: 15px;
  text-align: center;
}
.price { font-weight: bold; color: #2e7d32; }
button {
  background-color: #007bff;
  border: none;
  color: white;
  padding: 10px 20px;
  margin-top: 10px;
  border-radius: 8px;
  cursor: pointer;
}
button:hover { background-color: #0056b3; }

/* Header Bar */
.navbar {
    display:flex;
    justify-content:space-between;
    align-items:center;
    background:#ffffff;
    padding:10px 20px;
    box-shadow:0 2px 6px rgba(0,0,0,0.1);
}
.navbar a {
    text-decoration:none;
    margin-right:15px;
    font-size:18px;
}

/* Cart Badge */
.cart-badge {
    position:absolute;
    top:-10px;
    right:-10px;
    background:red;
    color:white;
    font-size:12px;
    padding:2px 6px;
    border-radius:50%;
}
</style>
</head>
<body>

<!-- 🔹 HEADER BAR -->
<div class="navbar">

    <!-- LEFT SIDE -->
    <div>
        <a href="products">🏠 Home</a>
        <a href="myOrders">📦 My Orders</a>

        <!-- Category Filter -->
        <form action="category" method="get" style="display:inline;">
    <select name="type" onchange="this.form.submit()" 
            style="padding:5px; border-radius:6px;">
        <option disabled selected>Category</option>
        <option value="Men">Men</option>
        <option value="Women">Women</option>
        <option value="Kids">Kids</option>
        <option value="Electronics">Electronics</option>
        <option value="Footwear">Footwear</option>
    </select>
</form>
    </div>

    <!-- CENTER SEARCH BAR -->
    <form action="searchProducts" method="get" 
    style="display:flex; align-items:center; width:40%;">
        <input type="text" name="keyword" placeholder="Search products..."
        style="width:80%; padding:7px; border:1px solid #aaa; border-radius:6px;">
        <button type="submit" 
        style="margin-left:5px; padding:7px 15px; background:#007bff; border:none; color:white; border-radius:6px;">
          🔍
        </button>
    </form>

    <!-- RIGHT SIDE CART ICON -->
    <div style="position:relative;">
        <a href="cart" style="font-size:24px; text-decoration:none;">
          🛒
          <span class="cart-badge">
            <%= session.getAttribute("cartCount") == null ? 0 : session.getAttribute("cartCount") %>
          </span>
        </a>
    </div>
    
     <!-- 🔹 LOGOUT BUTTON -->
        <a href="logout" 
           style="padding:8px 14px; background:red; color:white; 
                  text-decoration:none; border-radius:6px; font-weight:bold;">
           🚪 Logout
        </a>

</div>

<!-- 🔹 PAGE TITLE -->
<h2>🛍️ Our Products</h2>

<!-- 🔹 PRODUCT GRID -->
<div class="container">
<%
List<Products> list = (List<Products>) request.getAttribute("productList");
if (list != null && !list.isEmpty()) {
    for (Products p : list) {
%>
  <div class="card">
    <img src="<%=p.getImage()%>" alt="<%=p.getName()%>">
    <div class="card-content">
      <h3><%=p.getName()%></h3>
      <p><%=p.getDescription()%></p>
      <p class="price">₹<%=p.getPrice()%></p>
      <p>Category: <%=p.getCategory()%></p>

      <!-- Add to Cart -->
      <form action="addtocart" method="get">
        <input type="hidden" name="id" value="<%=p.getId()%>">
        <button type="submit">Add to Cart</button>
      </form>

      <!-- Buy Now -->
      <form action="buyNow" method="post">
        <input type="hidden" name="id" value="<%=p.getId()%>">
        <button type="submit" style="background:#28a745;">Buy Now</button>
      </form>

    </div>
  </div>
<% } } else { %>
  <p>No products found!</p>
<% } %>
</div>

</body>
</html>
