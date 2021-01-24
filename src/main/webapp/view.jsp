<%@page import="edu.java.entity.JSTLEmployee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View page</title>
</head>
<link rel = "stylesheet" href="CSS/index.css"/>
<body>

<h1>View Page</h1>

<div class="input-section">

<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
if(session.getAttribute("Employee") == null)
{
	response.sendRedirect("index.jsp");
}
%>

<table>
		<tr>
			<th>Employee Name</th>
			<th>Age</th>
			<th>Role</th>
		</tr>
		
			<% JSTLEmployee employee =  (JSTLEmployee)session.getAttribute("Employee");%>
		<tr><td><% out.println(employee.getName());%></td>
			<td><% out.println(employee.getAge());%></td>
			<td><% out.println(employee.getRole());%></td> </tr>
			
		</table>
</div>

</body>
</html>