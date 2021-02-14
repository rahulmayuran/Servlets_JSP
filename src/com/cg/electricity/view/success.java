package com.cg.electricity.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.electricity.dao.ElectricityDaoImpl;
import com.cg.electricity.dto.Electricity;



@WebServlet("/success")
public class success extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession ses=request.getSession(false);
		
		

        String name=(String)ses.getAttribute("name");
		int cid=(int) ses.getAttribute("cid"); 
		double unit=(double) ses.getAttribute("unit"); 
		double amnt=(double) ses.getAttribute("amnt"); 
		
		
		
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		out.print("Welcome "+name);
		out.print("<br/><h1>Electricity Bill for Consumer Number-"+cid+" is</h1>");
		out.print("<br/>Unit Consumed :"+unit);
		out.print("<br/>Net amount:"+amnt);
	
		
		
		
		
	}

}
