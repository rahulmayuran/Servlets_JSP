
package com.cg.bill.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConnection  {

	public static void main(String[] args) throws ClassNotFoundException{
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			
			System.out.println("Database connected");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
