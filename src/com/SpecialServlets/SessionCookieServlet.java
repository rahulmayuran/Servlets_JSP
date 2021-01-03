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

@WebServlet("/SessionCookieServlet")
public class SessionCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public SessionCookieServlet() {
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int amount = (int) session.getAttribute("amount");
		amount = amount*amount;
		String payment = (String) session.getAttribute("payment");
		
		PrintWriter out = response.getWriter();
		out.println(payment + " requests you to pay squared amount of " + amount + " rupees.");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//int pay = 0;
		Cookie cook[] = request.getCookies();
		for(Cookie c : cook)
		{
				//pay = Integer.parseInt(c.getValue());
				PrintWriter out = response.getWriter();
				out.println("<br>"+ c.getValue() + c.getName());
		}
		
		PrintWriter out = response.getWriter();
		//out.println("The payment method is : "+ pay);
				
	}

}
