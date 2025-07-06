package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerLoginDAO 
{
	public CustomerBean customerLogin(String UserName, String Password) 
	{
		CustomerBean cbean=null;
		try
		{
			Connection con=DBConnect.getCon();
			PreparedStatement pstmt=con.prepareStatement("select * from customer where UNAME=? and PWORD=?");
			pstmt.setString(1, UserName);
			pstmt.setString(2, Password);
			
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next())
			{
			    cbean=new CustomerBean();
				cbean.setUserName(rs.getNString(1));
				cbean.setPassword(rs.getNString(2));
				cbean.setFirstName(rs.getNString(3));
				cbean.setLastName(rs.getNString(4));
				cbean.setAddress(rs.getNString(5));
				cbean.setMailId(rs.getNString(6));
				cbean.setPhoneNumber(rs.getNString(7));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return cbean;
	}
}
