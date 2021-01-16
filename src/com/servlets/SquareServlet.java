package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SquareServlet")
public class SquareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SquareServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("Servlet initialized");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*we used an int object to retreive the object set in AddServlet as it is Object type*/
		int square = (int) request.getAttribute("toBeSquared");
		int squaredResult = square*square;
		PrintWriter output = response.getWriter();
		output.println("<br/>Squared value of the AddServlet parameter for number "+ square + " is "+ squaredResult);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/*This get Parameter works by getting the parameter from the get method
		 * of the AddServlet , where we have used send redirect and did URL rewriting*/
		int squared = Integer.parseInt(req.getParameter("n"));
		squared = squared * squared;
		
		PrintWriter out = resp.getWriter();
		out.println("The squared value is : "+ squared);
		System.out.println("Console : "+ squared);
	}
}
