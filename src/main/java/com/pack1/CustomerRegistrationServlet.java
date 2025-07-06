package com.pack1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/crs")
public class CustomerRegistrationServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException 
	{
			CustomerBean cbean=new CustomerBean();
			cbean.setUserName(req.getParameter("uName"));
			cbean.setPassword(req.getParameter("uPwd"));
			cbean.setFirstName(req.getParameter("uFname"));
			cbean.setLastName(req.getParameter("uLname"));
			cbean.setAddress(req.getParameter("uAddress"));
			cbean.setMailId(req.getParameter("uMail"));
			cbean.setPhoneNumber(req.getParameter("uPhone"));
			
			int rowcount=new CustomerRegisterDAO().customerRegister(cbean);
			
			if(rowcount>0)
			{
				System.out.println("customer registered");
				req.setAttribute("msg", "Customer Registration Successfull");
				RequestDispatcher rd=req.getRequestDispatcher("CustomerLogin.html");
				rd.forward(req, res);
			}
			else
			{
				System.out.println("customer not registered");
				req.setAttribute("msg", "Customer Registration UnSuccessfull");
				RequestDispatcher rd=req.getRequestDispatcher("CustomerLogin.html");
				rd.forward(req, res);
			}
		}
	
}
