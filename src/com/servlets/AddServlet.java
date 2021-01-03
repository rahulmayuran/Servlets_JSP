package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public String message;
	
	public void init() throws ServletException {
		message = "From init() method";
	}
	//Can edit this from index.html to make it post.
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException   {
		
			System.out.println(response.getClass());
			int n1 = Integer.parseInt(request.getParameter("first"));
			int n2 = Integer.parseInt(request.getParameter("second"));
			
			int sum = n1 + n2;

			System.out.println("Result is " + sum);
			
			PrintWriter output = response.getWriter();
			output.println("From the servlet the sum is : " + sum);
			
			request.setAttribute("toBeSquared", sum);
			RequestDispatcher dispatch = request.getRequestDispatcher("square");
			dispatch.forward(request, response);
	
	}
	//Can edit this from index.html to make it Get 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		
		int n1 = Integer.parseInt(request.getParameter("first"));
		int n2 = Integer.parseInt(request.getParameter("second"));
		int n = n1 + n2;
		response.sendRedirect("square?n="+n);
		
		
	}
	
}
