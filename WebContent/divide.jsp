
<%@page import="java.util.Formatter"%>
<%@page import="com.servletAnn.Entity.NavyOfficer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  errorPage="error.jsp"%>
 <%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Division and usage of JSTL tags</title>
</head>
<link rel="stylesheet" href="CSS/index.css"></link>
<body>

<!-- Never write the business/service/java coding in JSP's
The client will laugh if he pressed F12 or inspects it(If he is smart)-->

<h1>Playing with JSTL tags</h1>

<div class = "input-section">

	<%= "Hello from expression tag <br/>" %>
	
	<%
			double num1 = Double.parseDouble(request.getParameter("first"));
			double num2 = Double.parseDouble(request.getParameter("second"));
			double quo = num1/num2;
			Formatter fmt = new Formatter();
			fmt.format("%.3f", quo);
			out.println("The quotient is "+ fmt);
			fmt.close();
	%>
	
	<!-- Entity class to Servlet and to this JSP -->
	<br/><br/>
	
	<f:out value="From the Entity class, we have ${NavyObject.name} , 
	${NavyObject.age} years old who is a ${NavyObject.designation} 
	as an object in servlet"/>
	<br/>
	
	<!-- Using foreach loop to traverse through the list and maps -->
	<f:forEach var="list" items="${NavyList }">
		Iterating through a List variable of ${list.name}, ${list.age} who is ${list.designation} <br/>
	</f:forEach>
	<br/>
	
	<!-- foreach for map is little special as it has keys and values -->
	<f:forEach items="${NavyMap}" var = "mapentry">
		Iterating through the Hashmap for the keys : <f:out value="${mapentry.key}"/>
		and the value : <f:out value="${mapentry.value}"/><br/>
		These keys can be still sub written for <f:out value="${mapentry.key.name}
		who is ${mapentry.key.age } years old and a ${mapentry.key.designation }"/>  <br/>
	</f:forEach>
	<br/>
	
	<f:forEach items="${NavyArrayList}" var = "arraylist">
		Iterating through the arrayList for ${arraylist.name}, ${arraylist.age} who is a 
		${arraylist.designation}<br/>
	</f:forEach>
	
	
	</div>
	
</body>
</html>