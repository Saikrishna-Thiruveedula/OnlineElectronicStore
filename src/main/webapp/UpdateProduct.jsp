<%@page import="com.pack1.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body><center><h2>

		<%
			AdminBean abean=(AdminBean)session.getAttribute("abean");
			
			String msg=(String)request.getAttribute("msg");
			out.println("Hello Mr."+abean.getaFname()+"<br><br>");
			out.println(msg+"<br><br>");
		%>
		<a href="AddProduct.html">Add Product</a><br><br>
		<a href="view1">View Product</a><br><br>
		<a href="Logout">Logout</a>
</body>
</html>