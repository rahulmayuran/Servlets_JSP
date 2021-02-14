package com.cg.Billcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.bill.dto.Employee;
import com.cg.bill.exception.BillException;
import com.cg.billservice.Billservice;
import com.cg.billservice.BillserviceImpl;

/**
 * Servlet implementation class Billcontroller
 */
@WebServlet(urlPatterns={"/Billcontroller","/insertdetails","/customerbilldetails","/amount"})
public class Billcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Billservice service=new BillserviceImpl();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher disPatcher=null;
		String path=request.getServletPath();
		System.out.println("path is"+path);
		if(path.equals("/Billcontroller"))
		{
			disPatcher=request.getRequestDispatcher("register.jsp");
		}
		
		if(path.equals("/insertdetails"))
		{	HttpSession session=request.getSession(true);
		try {
			String name=request.getParameter("name");
			String mobilenumber=request.getParameter("number");
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			String password1=request.getParameter("password1");
		
			Employee emp=new Employee();
			boolean flag=false;
			flag=service.validatePassword(password,password1);
				if(flag)
				{
					emp.setName(name);
					emp.setMobilenumber(mobilenumber);
					emp.setUser_name(username);
					emp.setPassword(password);
					Employee emp1=new Employee();
					emp1=service.addEmployee(emp);
					session.setAttribute("emps",emp1);
					disPatcher=	request.getRequestDispatcher("customerhome.jsp");
				
					}
				else throw new BillException("password not matching");
		} catch (BillException e) {
			session.setAttribute("excep",e.getMessage());
			disPatcher=request.getRequestDispatcher("error.jsp");
		}
		}

		if(path.equals("/customerbilldetails"))
		{
			HttpSession session=request.getSession(false);
			disPatcher=request.getRequestDispatcher("paybill.jsp");
		
			
		}if(path.equals("/amount"))
		{        HttpSession session=request.getSession(false);
			
			      try {
					
					 String amnt=request.getParameter("money");
						boolean flag=service.checkAmount(amnt);
						if(flag)
						{    
							int money1=Integer.parseInt(amnt);
							int updatedbalance=750-money1;
							session.setAttribute("mon",updatedbalance);
							disPatcher=request.getRequestDispatcher("success.jsp");
						}else
							   throw new BillException("payment cannot be 0 or more than 750");
				}  catch (BillException e) {
					session.setAttribute("excep",e.getMessage());
					disPatcher=request.getRequestDispatcher("error.jsp");
					
				}
				
			       
		}
		disPatcher.forward(request,response);
			
		}
}

	


