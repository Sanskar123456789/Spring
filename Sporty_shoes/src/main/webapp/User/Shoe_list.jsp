<%@page import="com.example.demo.pojo.ShoePojo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href="/logout"><button>Logout</button></a>
<br>
<br>
<table>
<tr>
<th> Name </th>
<th> Company </th>
<th> Description </th>
<th> Price </th>
<th>Category</th>
<th> Order </th>
</tr>



<%
int intArray = (int)request.getAttribute("userid");
%>

<%
List<ShoePojo> shoes= (List<ShoePojo>)request.getAttribute("shoes");

for(ShoePojo s:shoes){
%>
<tr>
<td> <%=s.getName() %> </td>
<td> <%=s.getCompany() %> </td>
<td> <%=s.getDescription() %> </td>
<td> <%=s.getPrice() %> </td>
<td> <%=s.getCat_id().getCat() %> </td>
<td> <a href="order/+<%=s.getId()%>/<%=intArray %>" ><button> Order </button></a> </td>
</tr>

<%} %>
</table>


</body>
</html>