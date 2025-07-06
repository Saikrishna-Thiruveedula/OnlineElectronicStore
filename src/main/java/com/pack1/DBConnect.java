package com.pack1;

import java.sql.Connection;
	import java.sql.DriverManager;

	public class DBConnect 
	{
		public static Connection con=null;
		
		private DBConnect() 
		{
			
		}
		
		static
		{
			try
			{
				Class.forName("oracle.jdbc.OracleDriver");
				con=DriverManager.getConnection(DBInfo.DBUrl, DBInfo.DBUName, DBInfo.DBUPwd);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		public static Connection getCon()
		{
			return con;
		}
}
