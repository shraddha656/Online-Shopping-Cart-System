<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*, com.onlineshopping.model.AdminOrderView ,com.onlineshopping.model.Order"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Orders</title>
<style>
table {
    width: 80%;
    margin: auto;
    border-collapse: collapse;
}
th, td {
    border: 1px solid #888;
    padding: 10px;
    text-align: center;
}
.btn {
    display: inline-block;
    background: #007bff;
    color: white;
    padding: 8px 15px;
    text-decoration: none;
    margin: 20px;
}
</style>
<h2 style="text-align:center;">📦 All Orders</h2>

<table border="1" width="90%" align="center">
<tr>
    <th>Order ID</th>
    <th>Customer Name</th>
    <th>Mobile</th>
    <th>City</th>
    <th>Total Amount</th>
    <th>Payment Type</th>
    <th>Status</th>
<!--     <th>Details</th> -->
</tr>

<%
List<AdminOrderView> list = (List<AdminOrderView>) request.getAttribute("list");
if(list != null){
for(AdminOrderView o : list){
%>

<tr>
    <td><%=o.getOrderId()%></td>
    <td><%=o.getCustomerName()%></td>
    <td><%=o.getMobile()%></td>
    <td><%=o.getCity()%></td>
    <td>₹<%=o.getTotalAmount()%></td>
    <td><%=o.getPaymentType()%></td>
    <td><%=o.getPaymentStatus()%></td>
<%--     <td><a href="adminOrderDetails?id=<%=o.getOrderId()%>">View</a></td> --%>
</tr>

<%
}} 
%>
</table>
<div style="text-align:center;">
    <a href="adminDashboard.jsp" class="btn">⬅ Back to Dashboard</a>
</div>

</body>
</html>