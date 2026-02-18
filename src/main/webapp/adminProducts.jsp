<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.*,com.onlineshopping.model.Products" %>
     
     <%
    // ---- SESSION CHECK (ADDED) ----
   //HttpSession session = request.getSession(false);
    if (session == null || session.getAttribute("admin") == null) {
        response.sendRedirect("userLogin.jsp");
        return;   // stop page execution
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin — View Products</title>
<style>
table {
    width: 90%;
    margin: auto;
    border-collapse: collapse;
}
th, td {
    border: 1px solid #ccc;
    padding: 10px;
    text-align: center;
}
img {
    width: 70px;
    height: 70px;
    object-fit: cover;
}
.btn { padding: 6px 12px; background: #007bff; color: white; text-decoration:none; }
.btn-red { background: red; }
</style>
</head>
<<h2 style="text-align:center;">📦 All Products</h2>

<a href="adminDashboard.jsp" class="btn" style="margin-left:5%;">⬅ Back to Dashboard</a>
<a href="adminAddProduct.jsp" class="btn">➕ Add Product</a>

<table>
<tr>
<th>ID</th>
<th>Name</th>
<th>Price</th>
<th>Category</th>
<th>Qty</th>
<th>Image</th>
<th>Actions</th>
</tr>

<%
List<Products> list = (List<Products>) request.getAttribute("list");
if(list != null){
    for(Products p : list){
%>

<tr>
<td><%=p.getId()%></td>
<td><%=p.getName()%></td>
<td>₹<%=p.getPrice()%></td>
<td><%=p.getCategory()%></td>
<td><%=p.getQuantity()%></td>
<td><img src="<%=p.getImage()%>" /></td>
<td>
    <a class="btn" href="adminEditProduct?id=<%=p.getId()%>">Edit</a>
    <a class="btn btn-red" href="adminDeleteProduct?id=<%=p.getId()%>">Delete</a>
</td>
</tr>

<% }} %>

</table>
</body>
</html>