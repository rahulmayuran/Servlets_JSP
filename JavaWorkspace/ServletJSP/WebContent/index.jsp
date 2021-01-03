<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Squaring using a JSP file</title>
<link rel="stylesheet" href="CSS/index.css"></link>
</head>

<body>
<h1>Annotations and JSP with servlets</h1>

	<form action="square" method="post">
		<div class ="input-section" id="sec1">
			<label for="num1">Enter the number to be squared</label>
			<input type="number"  id="num1"  name="number"  required/>
			
			<button type="submit" value="square" id="sq">Square It!</button>
		</div>
	</form>
	
	<form action="add" method="post">
		<div class ="input-section" id="sec2">
			<button type="submit" value="add"  id="add">Forward to HTML</button>
		</div>
	</form>
</body>

</html>