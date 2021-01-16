package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			
			/*We can set the attribute from request object and use that attribute in another 
			 * servlet using getAttribute or in JSP using a dollar with this attribute*/
			request.setAttribute("toBeSquared", sum);
			
			//To call a servlet from another servlet , we use RequestDispatcher object
			RequestDispatcher dispatch = request.getRequestDispatcher("square");
			
			/*include method will append two response as a single response
			 * forward method simply forwards the request from server side to another servlet*/
			dispatch.include(request, response);
	
	}
	
	//Can edit this from index.html to make it Get 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		
		int n1 = Integer.parseInt(request.getParameter("first"));
		int n2 = Integer.parseInt(request.getParameter("second"));
		int n = n1 + n2;
		
		/*It is used to send the response to another HTML/JSP or servlet from client side
		 *It accepts absolute/relative url
		 *The operation that is done here is URL rewriting, we can use send Redirect to manipulate the 
		 *URL and also to send to a JSP using a forward slash/  */
		System.out.println("Using URL rewriting, added n1: "+n1+ " and n2: "+n2);
		response.sendRedirect("square?n="+n);
		
	}
	
}
