package com.cg.electricity.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.cg.electricity.Exception.ElectricException;


public class DatabaseConnection {

private static Connection conn;
	
	public static Connection getConnection() throws ElectricException{
		
		if(conn==null)
		{
			try
			{
				InitialContext ic=new InitialContext();
				DataSource ds=(DataSource)ic.lookup("java:/jdbc/jeeDS");
				conn=ds.getConnection();
			}
			catch(SQLException e)
			{
				throw new ElectricException("Problem in obtaining connection"+e.getMessage());
			}
			catch(NamingException e)
			{
				e.printStackTrace();
			}
		}
		return conn;
	}
	
}
