<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql"%>
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
		<br/>
		
		<c:out value="Fetching the values from SSMS DB tables"/>
		<br/>
		
		<!-- There should be a reference variable for datasource, driver class for SQL server
		and url that connects to DB created in SSMS, with user and password -->
		<sql:setDataSource var="db" 
		driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
		url="jdbc:sqlserver://localhost:1433;databaseName=ServletJSTLTagTest" 
		user="jstl" 
		password="jstl"/>
	
		<!-- Can write queries by creating a reference variable for query and mapping 
		the datasource variable using EL tag -->
		
		<!-- All DML operation can be done using update tag by referencing 
		the datasource variable and a update variable which is not used anyhow-->
		<sql:update dataSource="${db}" var="anyVar">
		Update dbo.JSTLEmployee set age=37 where name='Navin'
		</sql:update>
		
		<!-- DQL tag can be done using query tag by creating a resultset variable
		and referring the datasource variable-->
		<sql:query var="resultset" dataSource="${db}" > 
		Select * from dbo.JSTLEmployee
		</sql:query>
	
		<!-- Iterating the resultset using rows and using reference variable
		to access the column names in the db -->
		<table>
		<tr>
			<th>Employee Name</th>
			<th>Age</th>
			<th>Role</th>
		</tr>
		<c:forEach items="${resultset.rows}" var="employees">
		<tr>
			<td><c:out value="${employees.name}"/></td>
			<td><c:out value="${employees.age}"/></td>
			<td><c:out value="${employees.role}"/></td>
		 </tr>
		 </c:forEach>
		</table>
		
		</div>
		</form>
		
		
		
		<%--<c:redirect url="https://hackerrank.com/" context="hrank"></c:redirect>--%>
		
</body>
</html>