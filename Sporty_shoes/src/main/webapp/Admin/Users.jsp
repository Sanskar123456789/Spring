<%@page import="com.example.demo.pojo.UserPojo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users</title>
</head>
<body>
<a href="/AdminDashboard"><button>Back</button></a>

<table>
<tr>
<th>Name</th>
<th>Email</th>
<th>Address</th>
<th>Phone_No</th>
</tr>
<%
List<UserPojo> orders = (List<UserPojo>) request.getAttribute("Users"); 

for(UserPojo ss: orders){
%>
<tr>
<td><%= ss.getName() %></td>
<td><%= ss.getEmail() %></td>
<td><%= ss.getAddress() %></td>
<td><%= ss.getPhone_no() %></td>
</tr>
<%} %>
</table>
</body></html>