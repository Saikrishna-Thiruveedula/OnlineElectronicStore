<%@page import="java.util.Iterator"%>
<%@page import="com.pack1.ProductBean"%>
<%@page import="com.pack1.AdminBean"%>
<%@page import="java.util.ArrayList"%>
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
		ArrayList<ProductBean> al=(ArrayList<ProductBean>)session.getAttribute("ProductList");
		out.println("Hello "+abean.getaFname()+" These Are your Product Details<br><br>");
		if(al.size()==0)
		{
			out.println("No Products are Available/Inserted<br><br>");
		}
		else
		{
			Iterator<ProductBean> i=al.iterator();
			while(i.hasNext())
			{
				ProductBean pb=i.next();
				out.println(pb.getpCode()+" "+pb.getPName()+" "+pb.getpCompany()+" "+pb.getpPrice()+" "+pb.getpQuantity()+" "+
						"<a href='edit?pcode="+pb.getpCode()+"'> Edit</a>"+" "
						+"<a href='delete?pcode="+pb.getpCode()+"'>Delete</a><br><br>");

			}
		}
	%>
	</h1>
</body>
</html>