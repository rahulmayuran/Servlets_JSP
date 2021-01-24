<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
</head>
<link rel = "stylesheet" href="CSS/index.css"></link>
<body>
<h1>Welcome Page</h1>

<div class = "input-section">
<form action="funct" method="post">


<label for="id1">Enter your id</label>
<input type="number" id = "id1" name = "id" required>

<label for="str1">Enter your name</label>
<input type="text" id = "str1" name = "name" required>

<button type="submit" id="bid" value="Submit">Submit</button>

</form>
</div>

</body>
</html>