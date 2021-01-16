<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html >
<head >
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Payment Redirection</title>
<link rel="stylesheet" href="CSS/index.css"></link>
</head>
<body style= "background-color: lightblue">
<h1>Payment Authentication</h1>
<div class = input-section style="background-color: darkgray; color: white;margin-bottom: 1em">
	<% session = request.getSession();
			int amount = (int) session.getAttribute("amount");
			String paymentMode = (String) session.getAttribute("payment");
			out.println("The amount you're willing to pay is $" + amount + " using the " +
					 paymentMode +  " payment mode <br/>" );
	%>
</div>
<div class = input-section style="background-color: darkgray; color: white">
	Using directive tag to assign 'a = 1' <br/>
	<%! int a = 1;%>
	Printing 'a' using Expression tag =>
	<%= a %>
</div>
</body>
</html>
