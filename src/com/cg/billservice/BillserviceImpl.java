package com.cg.billservice;

import com.cg.Billl.dao.BillDao;
import com.cg.Billl.dao.BillDaoImpl;
import com.cg.bill.dto.Employee;
import com.cg.bill.exception.BillException;


public class BillserviceImpl implements Billservice{

	 BillDao billdao=new BillDaoImpl();
	
	public BillserviceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Employee addEmployee(Employee emp) throws BillException {
		// TODO Auto-generated method stub
		return billdao.addEmployee(emp);
	}

	@Override
	public boolean validatePassword(String password, String password1)
			throws BillException {
		boolean flag=false;
		if(password.equals(password1))
		{
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean checkAmount(String amnt) {
		boolean flag=false;
		int amount=Integer.parseInt(amnt);
		if(amount>0 && amount<750)
		{
			flag=true;
		}
		return flag;
	}
	

}
