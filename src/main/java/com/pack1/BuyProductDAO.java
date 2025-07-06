package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BuyProductDAO 
{
	ProductBean pbean=null;
	public ProductBean buyProduct(String pcode)
	{
		try
		{
			Connection con=DBConnect.getCon();
			PreparedStatement pstmt=con.prepareStatement("select * from product where pcode=?");
			pstmt.setString(1, pcode);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
				pbean=new ProductBean();
				pbean.setpCode(rs.getString(1));
				pbean.setPName(rs.getString(2));
				pbean.setpCompany(rs.getString(3));
				pbean.setpPrice(rs.getString(4));
				pbean.setpQuantity(rs.getString(5));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return pbean;
	}
}
