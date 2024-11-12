<%@page import="java.sql.ResultSet"%>
<%@page import="com.mysql.cj.protocol.SocksProxySocketFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>

	<h1 style="text-align: center;">All Users</h1>

	<table border="3" cellpadding="10" cellspacing="10" style="border-collapse: collapse; margin: auto;"> 
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Phone</th>
			<th>Password</th>
			<th colspan="2">Action</th>
		</tr>


		<%
		ResultSet rs = (ResultSet) request.getAttribute("rs");
		while (rs.next()) {
		%>
		<tr>
			<td><%= rs.getInt(1) %></td>
			<td><%=rs.getString(2)%></td>
			<td><%=rs.getString(3)%></td>
			<td><%=rs.getLong(4)%></td>
			<td><%=rs.getString(5)%></td>
			<td> <a href="delete?id=<%=rs.getInt(1) %>"><button>Delete</button></a> </td>
			<td> <button>Update</button> </td>
		</tr>
		<%
		}
		%>

	</table>




</body>
</html>