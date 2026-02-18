<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.util.*, com.onlineshopping.model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin - Users</title>

<style>
table {
    width: 80%;
    margin: auto;
    border-collapse: collapse;
}
th, td {
    border: 1px solid #aaa;
    padding: 10px;
    text-align: center;
}
h2 { text-align:center; }
</style>
</head>

<body>
	<h2>👤 All Registered Users</h2>

<a href="adminDashboard.jsp">⬅ Back to Dashboard</a><br><br>

<table>
<tr>
    <th>User ID</th>
    <th>Name</th>
    <th>Email</th>
    <th>Role</th>
</tr>

<%
List<User> list = (List<User>) request.getAttribute("users");

if(list != null){
    for(User u : list){
%>
<tr>
    <td><%=u.getUserId()%></td>
    <td><%=u.getName()%></td>
    <td><%=u.getEmail()%></td>
    <td><%=u.getRole()%></td>
</tr>
<%
    }
}
%>

</table>
</body>
</html>