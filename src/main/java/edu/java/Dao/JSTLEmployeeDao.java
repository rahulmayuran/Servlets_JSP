package edu.java.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import edu.java.entity.JSTLEmployee;

public class JSTLEmployeeDao {

	public JSTLEmployee getEmployee(int age) {
		
		
		JSTLEmployee employee = new JSTLEmployee();
		
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ServletJSTLTagTest","jstl","jstl");
			Statement state = con.createStatement();
			ResultSet result = state.executeQuery("Select * from JSTLEmployee where age = " + age);
			if(result.next()) {
				employee.setAge(result.getInt("Age"));
				employee.setName(result.getString("Name"));
				employee.setRole(result.getString("Role"));
			}
			con.close();
		} catch (Exception e) {
			System.out.println("Exception is : " + e.getMessage());
		}
		
		return employee;
		
		}	
		
	}

