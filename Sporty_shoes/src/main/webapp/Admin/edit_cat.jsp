<%@page import="com.example.demo.pojo.CategoryPojo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
</head>
<body>

<%
CategoryPojo obj = (CategoryPojo) request.getAttribute("Categories");

%>
<h1>Update shoe</h1>

<form action="/edit_category">
<br>
<input type="hidden" placeholder="Id" name="Id" value="<%=obj.getId() %>"><br><br>
<input type="text" placeholder="Name" name="Name" value="<%=obj.getCat() %>"><br><br>
<input type="submit">
</body>
</html>