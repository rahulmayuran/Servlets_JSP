package com.cg.electricity.service;

import com.cg.electricity.Exception.ElectricException;
import com.cg.electricity.dao.ElectricityDao;
import com.cg.electricity.dao.ElectricityDaoImpl;
import com.cg.electricity.dto.Electricity;

public class ElectricityServiceImpl implements ElectricityService  {

	ElectricityDao dao=new ElectricityDaoImpl();
	@Override
	public int calculatebill(Electricity elec) throws ElectricException {
		// TODO Auto-generated method stub
		return dao.calculatebill(elec);
	}
	@Override
	public String getName(int cid) throws ElectricException{
		// TODO Auto-generated method stub
		return dao.getName(cid);
	}

}
