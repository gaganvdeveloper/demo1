<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Page</title>
</head>
<body>
	<%
	
	
		ResultSet rs = (ResultSet) request.getAttribute("rs");
	
	
	%>




	<h1>Update Here</h1>
	
	<form action="update">
	<input type="text" name="id" value="<%= rs.getInt(1) %>" placeholder="Enter Id">
	<input type="text" name="name" value="<%= rs.getString(2) %>" placeholder="Enter Name">
	<input type="text" name="email" value="<%= rs.getString(3) %>" placeholder="Enter Email">
	<input type="text" name="phone" value="<%= rs.getLong(4) %>" placeholder="Enter Phone Number">
	<input type="text" name="password" value="<%= rs.getString(5) %>" placeholder="Enter Password">
		<button type="submit">Update</button>
	</form>
	
	
</body>
</html>