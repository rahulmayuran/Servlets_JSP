package com.cg.billservice;

import com.cg.bill.dto.Employee;
import com.cg.bill.exception.BillException;

public interface Billservice {
	Employee addEmployee(Employee emp) throws  BillException;
	boolean validatePassword(String password,String password1) throws BillException;
	boolean checkAmount(String amnt);
}
