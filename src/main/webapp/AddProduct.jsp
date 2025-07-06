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
			String msg=(String)request.getAttribute("msg");
		    out.println(msg+"<br><br>");
		%>
	
	<a href="AddProduct.html">Add Product</a><br><br>
	<a href="view1">View Products</a><br><br>
	<a href="Logout">Logout</a>
	</h1>
</body>
</html>