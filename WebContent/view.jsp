<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Page</title>
</head>
<link rel="stylesheet" href="CSS/index.css"></link>
<body>

<h1>View Page</h1>

<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

if(session.getAttribute("username") == null)
{
	response.sendRedirect("welcome.jsp");
}
%>

<div class="input-section">

<form action="logout" method="get">
	<button type="submit" value="Logout">Logout</button>
</form>

<sql:setDataSource var="db" 
		driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
		url="jdbc:sqlserver://localhost:1433;databaseName=ServletJSTLTagTest" 
		user="jstl" 
		password="jstl"/>
		
<sql:query var="rs" dataSource="${db}" > 
		Select * from dbo.UserValidation
		</sql:query>

<c:choose>
<c:when test="${! empty username}">		
	<sql:update dataSource="${db}" scope="session" var="any"> 
	Update dbo.UserValidation set password = '****' where password = 'hai'
	</sql:update>
</c:when>
<c:otherwise>
	<% response.sendRedirect("welcome.jsp"); %>
</c:otherwise>
</c:choose>

<c:out value="Welcome ${username}"></c:out> <br/>

<table>
	
	<thead></thead>
		<tbody>
				<tr><th>Username</th>
					<th>Password</th>
					<th>Date</th>
					<th>Empty Column</th>
					<th>Password Length</th></tr>
					
			<c:forEach items="${rs.rows}" var="user">
				<tr><td>${user.username}</td>
					<td>${user.password}</td>
					<td>${user.AddedDate}<td>
					<td>${fn:length(user.password) }</td></tr>
			</c:forEach>
			
		</tbody>
	<tfoot></tfoot>
</table>

</div>

</body>
</html>