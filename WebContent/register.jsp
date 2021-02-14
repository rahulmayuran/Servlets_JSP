<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
<form action="insertdetails" method="post">
<h2 align="center">AirSpace Telecomm</h2>
<h2 align="center">New User Registration Form</h2>
	<table align="center">
		<tr>
			<td><label>Enter Your Name</label></td>
			<td><input type="text" name="name"  required></td>
		</tr>
		<tr>
			<td><label>Mobile Number</label></td>
			<td><input type="text" name="number" pattern="[0-9]{10}" title="10 digits compulsary" required></td>
		</tr>
		<tr>
			<td><label>Username</label></td>
			<td><input type="text" name="username" pattern="[A-Za-z]{2,40}" title="Only characters allowed(minimum 2)" required></td>
		</tr>
		<tr>
			<td><label>Password</label></td>
			<td><input type="password" name="password" required></td>
		</tr>
		<tr>
			<td><label>Reenter Password</label></td>
			<td><input type="password" name="password1" required></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><button type="submit">Register</button></td>
		</tr>
	</table>
</form>

</body>
</html>