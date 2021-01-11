<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>JSTL tags and Fragmentation</title>
</head>
<link rel="stylesheet" href="CSS/index.css"></link>
<body>
<!-- using dollar is EL tag which is same as getting attribute from request -->
<h1>JSTL tags and divide operations</h1>

<!-- button click will forward to doGet method of servlet and gets forwarded to divide jsp -->
	<form action="square" method="get">
	<div class ="input-section" id="sec1">
	
		<c:out value="Welcome ${label}, From JSTL Tags "/><br/>
		
		<label for="num1">Enter the first number</label>
		<input type="number"  id="num1"  name="first"  step="0.01" required/>
		
		<label for="num2">Enter the second number</label>
		<input type="number"  id="num2"  name="second" step="0.01"  required/>
		
		<button type="submit" value="AddS" id="add-s">Divide</button>
		
		
	
	
		</div>
		</form>
		
		
		
		<%--<c:redirect url="https://hackerrank.com/" context="hrank"></c:redirect>--%>
		
</body>
</html>