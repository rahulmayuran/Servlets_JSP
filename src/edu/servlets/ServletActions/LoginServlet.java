package edu.servlets.ServletActions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import edu.servlets.DAO.DatabaseChecker;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/validate")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		DatabaseChecker checker = new DatabaseChecker();
		
		String username = req.getParameter("name");
		String password = req.getParameter("pass");
		
		if(checker.dataChecker(username, password)) {
			
			HttpSession session = req.getSession();
			session.setAttribute("username", username);
			resp.sendRedirect("view.jsp");
		}
		else {
			resp.sendError(HttpServletResponse.SC_BAD_GATEWAY, "Username/Password is wrong");
		}
		
	}

}
