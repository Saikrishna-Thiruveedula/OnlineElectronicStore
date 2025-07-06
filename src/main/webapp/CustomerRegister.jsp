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
		String msg=(String)request.getAttribute("msg");
		out.println(msg+"<br><br>");
	%>
	<a href="CustomerLogin.html">Login</a>
	</h1>
</body>
</html>