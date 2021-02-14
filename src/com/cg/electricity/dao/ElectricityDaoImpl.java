package com.cg.electricity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.electricity.Exception.ElectricException;
import com.cg.electricity.dto.Electricity;

public class ElectricityDaoImpl implements ElectricityDao {

	

	@Override
	public int calculatebill(Electricity elec) throws ElectricException {
		// TODO Auto-generated method stub
		
	
		
		
		int cid=elec.getCnum();
		
		String sql="insert into BillDetails values(?,?,?,?,?,sysdate)";
		Connection con=DatabaseConnection.getConnection();
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, fetchBillnum());
			ps.setInt(2,cid);
			ps.setDouble(3,elec.getCread());
			ps.setDouble(4,elec.getUnits());
			ps.setDouble(5, elec.getNamnt());	
			ps.executeUpdate();
			return cid ;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return 0;
		}
		
        
	}

	

	private int fetchBillnum() throws ElectricException
	{
		int eid=0;
		String query="select bill_num_seq.nextval from DUAL";
		Connection con=DatabaseConnection.getConnection();
		try
		{
			PreparedStatement st=con.prepareStatement(query);
			ResultSet rs=st.executeQuery();
			while(rs.next())
			{
			eid=rs.getInt(1);
			}
		}
		catch(SQLException e)
		{
			e.getMessage();
		}
		return eid;
	}

	@Override
	public String getName(int cid) throws ElectricException {
		// TODO Auto-generated method stub
		String name="";
		String sql2="select consumer_name from Consumer where consumer_num=?";
		Connection con=DatabaseConnection.getConnection();
		
		try
		{
			PreparedStatement ps=con.prepareStatement(sql2);
			ps.setInt(1, cid);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				name=rs.getString(1);
			}		
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return name;
	}
	
}
