package com.pack1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/delete")
public class DeleteProductServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		HttpSession session=req.getSession(false);
		if(session==null)
		{
			req.setAttribute("msg", "Your Session Expired");
			RequestDispatcher rd=req.getRequestDispatcher("AdminLogin.html");
			rd.forward(req, res);
		}
		else
		{
			String pcode=req.getParameter("pcode");
			int rowcount=new DeleteProductDAO().deleteProduct(pcode);
			if(rowcount>0)
			{
				req.setAttribute("msg", "Selected Product Deleted");
				RequestDispatcher rd=req.getRequestDispatcher("DeleteProduct.jsp");
				rd.forward(req, res);
			}
			else
			{
				throw new ServletException("Data NOT Deleted");
			}
		}
	}
}
