<%@page import="com.example.demo.pojo.CategoryPojo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shoe</title>
</head>
<body>
<h2>Enter Shoe Details</h2>


<form action="/newShoe">
<br>
<input type="text" placeholder="Name" name="Name"><br><br>
<input type="text" placeholder="Company" name="Company"><br><br>
<input type="text" placeholder="Description" Name="Description"><br><br>
<input type="text" placeholder="Price" name="Price"><br><br>
<input type="text" placeholder="Quantity" name="Quantity"><br>
<select name="cat_id">
<%
List<CategoryPojo> list = (List<CategoryPojo>) request.getAttribute("Categories");

for(CategoryPojo l:list){
%>
<option value="<%= l.getId()%>"><%=l.getCat() %></option>
<%}%>
</select>

<br>
<input type="submit">

</form>
</body>
</html>