<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
</head>
<link rel="stylesheet" href="CSS/index.css"></link>
<body>

<h1>Welcome Page</h1>

<div class = "input-section">

<form action="validate" method="post">

<label for="name1">Enter your Name</label>
<input type="text" id = "name1" name = "name" min="5" required>

<label for="pass1">Enter your password</label>
<input type="password" id = "pass1" name = "pass" min="3" required>

<button type="submit" id="passwordCheck" value="Submit">Submit</button>

</form>

</div>

</body>
</html>