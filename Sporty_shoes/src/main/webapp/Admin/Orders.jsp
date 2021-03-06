<%@page import="com.example.demo.pojo.CategoryPojo"%>
<%@page import="com.example.demo.pojo.OrderPojo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Orders</title>
</head>
<body>
<a href="/AdminDashboard"><button>Back</button></a>

<h4>Filter By</h4>
Date :<input type="date">
Category :
	<select id="catrgory" onchange="filterByCategory()">
			<option value="-1">All</option>
		<%
		List<CategoryPojo> category = (List<CategoryPojo>) request.getAttribute("Category");
		for(CategoryPojo c:category){
		%>
			<option value="<%=c.getId() %>"><%=c.getCat() %></option>
		<%
		}
		%>
	</select>
<br>
<br>
<table style="width: 100%;border: 1px solid;" id="table">
	<tr>
		<th>Shoe Id</th>
		<th>Category</th>
		<th>Quantity</th>
		<th>Total</th>
		<th>User Id</th>
		<th>Date</th>
	</tr>
	<%
	List<OrderPojo> orders = (List<OrderPojo>) request.getAttribute("Orders"); 
	for(OrderPojo ss: orders){
	%>
		<tr>
			<td>
				<br>
				name: <%=ss.getShoe_id().getName() %>
				<br>
				company: <%=ss.getShoe_id().getCompany() %>
				<br>
				price: <%=ss.getShoe_id().getPrice() %>
			</td>
			<td>
				<%=ss.getShoe_id().getCat_id().getCat() %>
			</td>
			<td>
				<%= ss.getQuan() %>
			</td>
			
			<td>
				<%= ss.getTotal()*ss.getQuan() %>
			</td>
			
			<td>
				<br>
				Name :<%=ss.getUser_id().getName() %>
				<br>
				Address :<%=ss.getUser_id().getAddress() %>
				<br>
				Phone No. :<%=ss.getUser_id().getPhone_no() %>
			</td>
			<td>
				<%=ss.getDate()%>
			</td>
		</tr>
	<%} %>
</table>

<script>
function filterByCategory(){
	var category = document.getElementById("catrgory");
	var table = document.getElementById("table");
	console.log(table.columns,category.value);
}
</script>

</body>
</html>