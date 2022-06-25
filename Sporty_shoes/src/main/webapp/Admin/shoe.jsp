<%@page import="com.example.demo.pojo.ShoePojo"%>
<%@page import="java.util.List"%>
<%@page import="com.example.demo.dao.ShoeDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.example.demo.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shoes</title>
</head>
<body>

<a href="/AdminDashboard"><button>Back</button></a>

<a href="/shoe_new">
<button> New Shoe </button>
</a>

<table>
<tr>
<th> Name </th>
<th> Company </th>
<th> Description </th>
<th> Category </th>
<th> Price </th>
<th> Quantity </th>
<th> Edit / Delete </th>
</tr>


<%
List<ShoePojo> shoes= (List<ShoePojo>)request.getAttribute("shoes");

for(ShoePojo s:shoes){
%>


<tr>
<td> <%=s.getName() %> </td>
<td> <%=s.getCompany() %> </td>
<td> <%=s.getDescription() %> </td>
<td> <%=s.getCat_id().getCat() %> </td>
<td> <%=s.getPrice() %> </td>
<td> <%=s.getQuantity() %> </td>
<td> <a href="edit/+<%=s.getId()%>" ><button> Edit </button></a> <a href="deleteShoe/<%=s.getId() %>"><button> Delete </button></a> </td>
</tr>

<%} %>
</table>

</body>
</html>