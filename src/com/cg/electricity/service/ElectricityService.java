package com.cg.electricity.service;

import com.cg.electricity.Exception.ElectricException;
import com.cg.electricity.dto.Electricity;

public interface ElectricityService {

	public int calculatebill(Electricity elec) throws ElectricException;

	public String getName(int cid) throws ElectricException;

}
