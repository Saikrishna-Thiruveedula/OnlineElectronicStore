<%@page import="com.pack1.ProductBean"%>
<%@page import="com.pack1.AdminBean"%>
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
	AdminBean abean=(AdminBean)session.getAttribute("abean");
	ProductBean pb=(ProductBean)request.getAttribute("pbean");
	out.println("Hello "+abean.getaFname()+" "+pb.getPName()+" Details available for edit <br><br>");
	%>
	<form action="update" method="post">
	
	Product Price : <input type="text" name="pprice" value="<%=pb.getpPrice()%>"><br><br>
	Product Quantity : <input type="text" name="pqty" value="<%=pb.getpQuantity() %>"><br><br>
	<input type="hidden" name="pcode" value="<%=pb.getpCode()%>"><br><br>
	<input type="submit" value="Update">
	
	</form>	
</body>
</html>