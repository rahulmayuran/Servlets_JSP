<%@page import="java.util.Formatter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dividing</title>
</head>

<body>
	<%= "Hello from expression tag <br/>" %>
	
	<%
	try{
			double num1 = Double.parseDouble(request.getParameter("first"));
			double num2 = Double.parseDouble(request.getParameter("second"));
			double quo = num1/num2;
			Formatter fmt = new Formatter();
			fmt.format("%.3f", quo);
			out.println("The quotient is "+ fmt);
			fmt.close();
	}
		catch(Exception e){
		out.println("Exception thrown " + e.getMessage());
		} 
	/* finally{
		out.println("Finally block");
	} */
	%>
</body>
</html>