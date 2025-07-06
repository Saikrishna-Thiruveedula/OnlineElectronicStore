<%@page import="java.util.Iterator"%>
<%@page import="com.pack1.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.pack1.CustomerBean"%>
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
		CustomerBean cbean=(CustomerBean)session.getAttribute("cbean");
		ArrayList<ProductBean> al=(ArrayList<ProductBean>)session.getAttribute("ProductList");
		out.println("Hello Mr."+cbean.getFirstName()+"<br><br>");
		
		if(al.size()==0)
		{
			out.println("There are No Products to Display In the Store");
		}
		else
		{
			Iterator<ProductBean> i=al.iterator();
			while(i.hasNext())
			{
				ProductBean pb=i.next();
				out.println("Product Code: "+pb.getpCode()+"<br>");
				out.println("Product Name: "+pb.getPName()+"<br>");
				out.println("Product Company: "+pb.getpCompany()+"<br>");
				out.println("Product Price: "+pb.getpPrice()+"<br>");
				out.println("Product Quantity :"+pb.getpQuantity()+"<br>");
				out.println("<a href='Buy?pcode=" + pb.getpCode() + "'>Buy</a><br><br>");;
			}
		}
	%>
	<a href="Logout">Logout</a><br><br>
</body>
</html>