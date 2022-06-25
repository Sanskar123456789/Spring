<%@page import="com.example.demo.pojo.ShoePojo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirm Order</title>
</head>
<body>
<%
ShoePojo shoe = (ShoePojo) request.getAttribute("Shoe_details");
int userid = (int)request.getAttribute("userid");

%>

<div class="shoe">
<h3>Shoe Details</h3>
	<br>
	<div class="Shoe_details">
	<hr>
	Name : &nbsp;&nbsp;&nbsp;<%= shoe.getName() %>
	<br>
	Company:&nbsp;&nbsp;&nbsp; <%= shoe.getCompany() %>
	<br>
	Price :&nbsp;&nbsp;&nbsp;<%= shoe.getPrice() %>
	<br>
	Description : &nbsp;&nbsp;&nbsp;<%= shoe.getDescription() %>
	<br>
		<div class="quantity">
		Select Quantity
		<form action="confirm_order">
			<input type="hidden" name="shoeid" value="<%= shoe.getId()%>">
			<input type="hidden" name="userid" value="<%= userid%>">
			<select name="quan">
			<% for(int i=1;i<=shoe.getQuantity();i++)
			{
			%>
			<option value="<%=i%>"><%=i%></option>
			<%} %>
			</select>
			
			<input type ="submit">
		</form>
		</div>
	</div>
</div>

</body>
</html>