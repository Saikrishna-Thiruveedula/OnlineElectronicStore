package com.pack1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Buy")
public class BuyProductServlet extends HttpServlet
{
	
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
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
			ProductBean pbean=new BuyProductDAO().buyProduct(pcode);
			if (pbean != null)
			{
                req.setAttribute("pbean", pbean);  
            } else 
            {
                req.setAttribute("msg", "Product not found");
            }
			RequestDispatcher rd=req.getRequestDispatcher("BuyProduct.jsp");
			rd.forward(req, res);
		}
	}
}
