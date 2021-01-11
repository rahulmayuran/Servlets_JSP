package com.servletAnn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//getting the uname from jsp as parameter,
		String username = (String) request.getParameter("uname");
		//setting it to label attribute
		request.setAttribute("label", username);
		
		RequestDispatcher rdisp = request.getRequestDispatcher("entry.jsp");
		rdisp.forward(request, response);

	}

}
