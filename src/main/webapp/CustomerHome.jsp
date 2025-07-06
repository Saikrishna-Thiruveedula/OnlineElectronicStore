<%@page import="com.pack1.CustomerBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center><h1>
	<%
	CustomerBean cbean=(CustomerBean)session.getAttribute("cbean");
	out.println("Welcome Mr."+cbean.getFirstName()+"!!<br><br>");
	%>
	<a href="view2">View Products</a><br><br>
	<a href="Logout">Logout</a><br><br>
</body>
</html>