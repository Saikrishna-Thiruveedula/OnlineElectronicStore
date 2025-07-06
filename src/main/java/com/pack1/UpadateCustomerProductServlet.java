package com.pack1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/buy")
public class UpadateCustomerProductServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		HttpSession session=req.getSession(false);
		if(session==null)
			{
				req.setAttribute("msg", "Your Session Expired");
				RequestDispatcher rd=req.getRequestDispatcher("CustomerLogin.html");
				rd.forward(req, res);
			}
		else
			{

			String pcode=req.getParameter("pcode");
			String prqty=req.getParameter("prqty");
			String pprice=req.getParameter("pprice");
			String pqty=req.getParameter("pqty");
			
			int rqty=Integer.parseInt(prqty);
			int qty=Integer.parseInt(pqty);
			double price=Integer.parseInt(pprice);
			
			if(rqty<=qty)
			{
				String nqty=String.valueOf(qty-rqty);
				
				String TotalPrice=String.format("%.2f", price*rqty);
				
				ArrayList<ProductBean> al=(ArrayList<ProductBean>)session.getAttribute("ProductList");
				ProductBean pb=null;
				
				Iterator<ProductBean> i=al.iterator();
				while(i.hasNext())
				{
					pb=i.next();
					if(pcode.equals(pb.getpCode()))
					{
						break;
					}
				}
				pb.setpQuantity(nqty);
				
				int rowcount=new UpdateCustomerProductDAO().updateProduct(pb);
				if(rowcount>0)
				{
					req.setAttribute("msg", "Your Order Placed Successfully");
					req.setAttribute("pqty", rqty);
					req.setAttribute("pprice", pprice);
					req.setAttribute("TotalPrice", TotalPrice);
					RequestDispatcher rd=req.getRequestDispatcher("OrderConfirmed.jsp");
					rd.forward(req, res);
				}
			}
			else
			{
				req.setAttribute("msg", "Order Not Placed");
				RequestDispatcher rd=req.getRequestDispatcher("BuyProduct.jsp");
				rd.forward(req, res);
			}
	}
	}
}
