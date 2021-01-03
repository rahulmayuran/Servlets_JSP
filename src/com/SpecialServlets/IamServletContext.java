package com.SpecialServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/IamServletContext")
public class IamServletContext extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Hi ");
		
		ServletContext context = getServletContext();
		String pname = context.getInitParameter("name");
		String page = context.getInitParameter("age");
		out.println(pname + ", The age from ServletContext is " + page);
		
		String age = getServletConfig().getInitParameter("age");
		out.println("<br/> The age from Servletconfig is : "+ age);
	}

}
