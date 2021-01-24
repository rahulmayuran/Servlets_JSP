package edu.servlets.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseChecker {

	String username = "jstl";
	String password = "jstl";
	String url = "jdbc:sqlserver://localhost:1433;databaseName=ServletJSTLTagTest";
	String query = "Select * from dbo.UserValidation where username = ? and password = ?";

	
	public boolean dataChecker(String user, String pass) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection connection = DriverManager.getConnection(url,username,password);
			PreparedStatement prepared = connection.prepareStatement(query);
			prepared.setString(1, user);
			prepared.setString(2, pass);
			ResultSet rs = prepared.executeQuery();
			
			 if(rs.next()) {
				return true;
			 }
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("The exception is " + e.getMessage());
		}
		
		return false;
		
	}
}
