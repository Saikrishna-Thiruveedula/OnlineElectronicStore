<%@page import="com.pack1.BuyProductDAO"%>
<%@page import="com.pack1.ProductBean"%>
<%@page import="com.pack1.CustomerBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body><center><h1>
	<%
		CustomerBean cbean=(CustomerBean)session.getAttribute("cbean");
		String msg=(String)request.getAttribute("msg");
		out.println("Hello "+cbean.getFirstName()+"<br><br>");
		out.println(msg+"<br><br>");
	%>
	
		<p>Product Price:${pprice}</p>
		<p>Required Quantity :${pqty}</p>
		<p>Total Price : ${TotalPrice}</p>
		
		<a href="view2">View Product</a><br><br>
		<a href="Logout">Logout</a>
</body>
</html>