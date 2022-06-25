<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="com.example.demo.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<th>Id</th>
<th>Name</th>
<th>Email</th>
<tr>
<%
	List<pojo> s=(List<pojo>) request.getAttribute("list");
	for(pojo ss:s){
%>
	<tr>
		<td><%=ss.getId()   %></td>
		<td><%=ss.getName() %></td>
		<td><%=ss.getName() %></td>
	</tr>
<%}%>	
</table>
</body>
</html>