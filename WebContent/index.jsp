<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Squaring using a JSP file</title>
<link rel="stylesheet" href="CSS/index.css"></link>
</head>

<body>
<h1>Annotations and JSP with servlets</h1>

<!--the form action maps to AnnotatedServlet-->
	<form action="square" method="post">
		<div class ="input-section" id="sec1">
			<label for="num1">Enter any number</label>
			<input type="number"  id="num1"  name="number"  required/>
			
			<button type="submit" value="square" id="sq">square root</button>
		</div>
	</form>
	
<!-- Maps to AddServlet, eliminates the need of <servlet> & <servlet-mapping>  -->	
	<form action="add" method="post">
		<div class ="input-section" id="sec2">
			<label for="uid">Enter the name</label>
			<input type="text"  name="uname" id ="uid" required="required"/>
			<button type="submit" value="add"  id="add">Forward to HTML</button>
		</div>
	</form>
</body>

</html>