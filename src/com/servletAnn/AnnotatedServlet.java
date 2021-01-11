package com.servletAnn;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.servletAnn.Entity.NavyOfficer;

@WebServlet("/square")
public class AnnotatedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		/*
		 * A program to find out the square root of a number 
		 * without using Math.sqrt() function, which requires, dividing by 2*/
		
			try {
				//Let number be 25
				int number = Integer.parseInt(request.getParameter("number"));
				
				//defining two double variables
				double half;
				double temp;
				
				//Now, half becomes 12.5XXD
				half = number/2;
				
				//Whatever be the condition, these statements are executed as its do-while
				do {
					//now temp is 12.5XXD 
					//2nd loop, where temp = 7.25
					temp = half;
					//12.5 = (12.5+(25/12.5))/2
					//2nd loop, 7.25 = (7.25+(25/7.25))/2
					half = (temp+(number/temp))/2;
					//7.25
					//2nd loop, 5
				}
				//condition is that , until it becomes 0, the loop runs
				//loop exits as temp = 5 and half =5.
				while((temp-half)!=0);
				
				PrintWriter out = response.getWriter();
				out.println("The square root of the number is " + half);
				String decide = ((half*half)/number) == 1 ?"Perfect Square Number":"Not a square number";
				out.println(decide);
				
			} catch (Exception e) {
			   PrintWriter outp = response.getWriter();
			   outp.print("Details of exception thrown from servlet: "+ e);
			}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
/*
 * Making use of POJO classes in Servlets to create list objects and mapping to JSP*/
		
		//Creating a NavyOfficer object that holds these values.
		NavyOfficer navyOf = new NavyOfficer(2, "Mathew", 26, "Junior officer");
		
		//Creating a List of NavyOfficer objects and using Arrays.asList that converts 
		//arrays to list. Should provide a Wrapper class instead of datatype arrays
		List<NavyOfficer> navyList = Arrays.asList(new NavyOfficer(1, "Alex", 33, "Lieutenant")
				,new NavyOfficer(3, "Carbera", 45, "Captain"));	
		
		//Using ArrayList object and adding NavyOfficer object using add function, Be careful with 
		//Linkedlist as there might be problems while serializing the session(NonSerializableObj Exc).
		List<NavyOfficer> navyArrayList = new ArrayList<NavyOfficer>();
		navyArrayList.add(new NavyOfficer(6, "Fernando", 12, "Visitor"));
		navyArrayList.add(new NavyOfficer(7, "Gill", 5, "toddler"));
		
		//Using Map object with key as NavyOfficer object and value as String and using put
		Map<NavyOfficer, String> navyMap = new HashMap<NavyOfficer, String>();
		navyMap.put(new NavyOfficer(4, "Donal", 34, "Pirate"), "Brave");
		navyMap.put(new NavyOfficer(5, "Elektra", 56, "Retired Captain"), "Persistent");
		
		//Using request object to set the attribute and retrieved using EL tags in JSP
		request.setAttribute("NavyObject", navyOf);
		request.setAttribute("NavyList", navyList);
		request.setAttribute("NavyMap", navyMap);
		request.setAttribute("NavyArrayList", navyArrayList);
		
		RequestDispatcher rd = request.getRequestDispatcher("divide.jsp");
		rd.forward(request, response);
	}
}
