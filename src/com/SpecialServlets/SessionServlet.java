package com.SpecialServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int amount = Integer.parseInt(request.getParameter("amount"));
		String payment = request.getParameter("payment");
		
		HttpSession session = request.getSession();
		session.setAttribute("amount", amount);
		session.setAttribute("payment", payment);
		
		response.sendRedirect("getsession");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int amount = Integer.parseInt(request.getParameter("amount"));
		String payment = request.getParameter("payment");
		
		 
		 Cookie cookie = new Cookie("payment" , payment+ "");
		 response.addCookie(cookie);
		 
		 System.out.println("The cookie value is : "+cookie);
		
		response.sendRedirect("getsession");
	}

}
