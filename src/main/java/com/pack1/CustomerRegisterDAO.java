package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CustomerRegisterDAO 
{
	public int customerRegister(CustomerBean cb)
	{
		int rowcount=0;
		try
		{
			Connection con=DBConnect.getCon();
			PreparedStatement pstmt=con.prepareStatement("insert into customer values(?,?,?,?,?,?,?)");
			pstmt.setString(1, cb.getUserName());
			pstmt.setString(2,cb.getPassword() );
			pstmt.setString(3,cb.getFirstName() );
			pstmt.setString(4,cb.getLastName() );
			pstmt.setString(5,cb.getAddress() );
			pstmt.setString(6,cb.getMailId() );
			pstmt.setString(7, cb.getPhoneNumber());
			
			 rowcount=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rowcount;
	}
}
