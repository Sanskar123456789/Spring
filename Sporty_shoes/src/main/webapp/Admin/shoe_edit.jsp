<%@page import="java.util.List"%>
<%@page import="com.example.demo.dao.CatDao"%>
<%@page import="com.example.demo.pojo.CategoryPojo"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="com.example.demo.pojo.ShoePojo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Shoe</title>
</head>
<body>

<%
ShoePojo obj = (ShoePojo) request.getAttribute("shoe");

%>
<h1>Update shoe</h1>

<form action="/edit_shoe">
<br>
<input type="hidden" placeholder="Id" name="Id" value="<%=obj.getId() %>"><br><br>
<input type="text" placeholder="Name" name="Name" value="<%=obj.getName() %>"><br><br>
<input type="text" placeholder="Company" name="Company" value="<%=obj.getCompany() %>"><br><br>
<input type="text" placeholder="Description" Name="Description" value="<%=obj.getDescription() %>"><br><br>
<input type="number" placeholder="Price" name="Price" value="<%=obj.getPrice() %>"><br><br>
<input type="number" placeholder="Quantity" name="Quantity" value="<%=obj.getQuantity() %>"><br>
<br>
<select name="cat_id">
<%
List<CategoryPojo> list = (List<CategoryPojo>) request.getAttribute("Categories");

for(CategoryPojo l:list){
	if(obj.getCat_id().getId()!=l.getId()){
%>
<option value="<%= l.getId()%>"><%=l.getCat() %></option>
<%}else{
	%>
<option value="<%= l.getId()%>" selected><%=l.getCat() %></option>
<%}
}%>
</select>
<br>
<input type="submit">

</body>
</html>