<%@page import="com.example.demo.pojo.CategoryPojo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Categories</title>
</head>
<body>


<a href="/AdminDashboard"><button>Back</button></a>

<a href="/cat_new">
<button> New Category </button>
</a>

<table>
<tr>
<th> Name </th>
<th> Edit / Delete </th>
</tr>

<%
List<CategoryPojo> shoes= (List<CategoryPojo>)request.getAttribute("Categories");

for(CategoryPojo s:shoes){
%>

<tr>
<td> <%=s.getCat() %> </td>
<td> 
	<a href="edit_cat/<%=s.getId()%>" ><button> Edit </button></a> 
    <a href="deleteCat/<%=s.getId() %>"><button> Delete </button></a> 
</td>
</tr>

<%} %>
</table>


</body>
</html>