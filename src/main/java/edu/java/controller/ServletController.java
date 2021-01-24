package edu.java.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.java.Dao.JSTLEmployeeDao;
import edu.java.entity.JSTLEmployee;

/**
 * Servlet implementation class ServletController
 */
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int age = Integer.parseInt(request.getParameter("age"));
		HttpSession session = request.getSession();
		
		JSTLEmployeeDao employeeDao = new JSTLEmployeeDao();
		JSTLEmployee employee = employeeDao.getEmployee(age);
		
		if(age != employee.getAge())
		{
			response.sendRedirect("navigate.jsp");
		}
		else {
	
		session.setAttribute("Employee", employee);
		
		RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
		rd.forward(request, response);
		
		}
	}

}
