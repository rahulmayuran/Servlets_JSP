package com.cg.electricity.BillController;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.electricity.Exception.ElectricException;
import com.cg.electricity.dto.Electricity;
import com.cg.electricity.service.ElectricityService;
import com.cg.electricity.service.ElectricityServiceImpl;


@WebServlet("/calculate")
public class CalculateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession sess=request.getSession();
		
		String cnum=request.getParameter("cnum");
		String lread=request.getParameter("lread");
		String cread=request.getParameter("cread");
		
		Electricity elec=new Electricity();
		
		elec.setCnum(Integer.parseInt(cnum));
		elec.setLread(Double.parseDouble(lread));
		elec.setCread(Double.parseDouble(cread));
		elec.setUnits(calunit(elec.getLread(),elec.getCread()));
		elec.setNamnt(calnamnt(elec.getLread(),elec.getCread()));
		
		ElectricityService service=new ElectricityServiceImpl();
		try {
			
		    int cid=service.calculatebill(elec);
		    String name=service.getName(cid);
		    double units=elec.getUnits();
		    double namnt=elec.getNamnt();
		  
		    sess.setAttribute("name", name);
		    sess.setAttribute("cid", cid);
		    sess.setAttribute("unit", units);
		    sess.setAttribute("amnt", namnt);
			RequestDispatcher disp=request.getRequestDispatcher("success");
			disp.forward(request, response);
			
			
		} catch (Exception e) {
			
			String message=e.getMessage();
			request.setAttribute("error", message);
			RequestDispatcher disp=request.getRequestDispatcher("failure");
			disp.forward(request, response);
		}
		
	}
	
public static  double calnamnt(double lread, double cread) {
		
		double nm=0;		
	    double unit=calunit(lread,cread);
		 nm=unit*1.5+100;
		
		return nm;
	
	}

	public static double calunit(double lread, double cread) {
		
		double units=lread-cread;
		return units;
	}

}
