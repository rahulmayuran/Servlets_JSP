package com.cg.electricity.dao;

import com.cg.electricity.Exception.ElectricException;
import com.cg.electricity.dto.Electricity;

public interface ElectricityDao {
	
	public int calculatebill(Electricity elec) throws ElectricException;

	public String getName(int cid) throws ElectricException ;

}
