package com.cg.Billl.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.bill.dto.Employee;
import com.cg.bill.exception.BillException;
import com.cg.bill.util.DbConnection;


public class BillDaoImpl implements BillDao {
	PreparedStatement pstm=null;
	Connection con=null;
	public BillDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Employee addEmployee(Employee emp) {
		String query="insert into users values(?,?,?,?)";
	int rows=0;
		try {
			con=DbConnection.getConnection();
		} catch (BillException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
		pstm=con.prepareStatement(query);
		pstm.setString(1,emp.getName());
		pstm.setString(2,emp.getUser_name());
		pstm.setString(3,emp.getPassword());
		pstm.setString(4,emp.getMobilenumber());
		rows=pstm.executeUpdate();

		}catch(SQLException e)
		{
			
		}
		finally{
			if(con!=null){
				try{
				pstm.close();
				con.close();
			}catch(SQLException e)
			{
				
			}
		}
	}
		return emp ;

	
	}

}
