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
    CustomerBean cbean = (CustomerBean) session.getAttribute("cbean");
    ProductBean pbean = (ProductBean) request.getAttribute("pbean");  

    if (cbean != null) {
        out.println("<h1>" + cbean.getFirstName() + " Your Product Details <br><br></h1>");
    } else {
        out.println("<h1>Customer information is missing!<br></h1>");
    }

    if (pbean != null) {
        out.println("<h2>Product Name: " + pbean.getPName() + "<br></h2>");
        out.println("<h2>Product Company: " + pbean.getpCompany() + "<br></h2>");
        out.println("<h2>Product Price: " + pbean.getpPrice() + "<br></h2>");
        out.println("<h2>Available Quantity: " + pbean.getpQuantity() + "<br></h2>");
    } else {
        out.println("<h2>Product information is missing!<br></h2>");
    }
%>

	
	<form action="buy" method="post">
    <h2>Required Quantity<input type="number" name="prqty" ><br><br></h2>

    <% if (pbean != null) { %>
        <input type="hidden" name="pcode" value="<%= pbean.getpCode() %>">
        <input type="hidden" name="pprice" value="<%= pbean.getpPrice() %>">
        <input type="hidden" name="pqty" value="<%= pbean.getpQuantity() %>">
    <% } %>

    <input type="submit" value="BUY">
</form>
	
</body>
</html>