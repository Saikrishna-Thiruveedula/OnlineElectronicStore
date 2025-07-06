package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddProductDAO 
{
	public int addProduct(ProductBean pb)throws Exception
	{
		int rowcount=0;
		
		try
		{
			Connection con=DBConnect.getCon();
			PreparedStatement pstmt=con.prepareStatement("insert into product values(?,?,?,?,?)");
			pstmt.setString(1, pb.getpCode());
			pstmt.setString(2, pb.getPName());
			pstmt.setString(3, pb.getpCompany());
			pstmt.setString(4, pb.getpPrice());
			pstmt.setString(5, pb.getpQuantity());
			rowcount=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			//e.printStackTrace();
			throw e;
		}
		return rowcount;
	}
}
