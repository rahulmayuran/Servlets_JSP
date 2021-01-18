<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="x" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Function Tags</title>
</head>
<link rel="stylesheet" href="CSS/index.css"></link>
<body>

<!-- Function tags are accessed using the taglib uri and a prefix, almost similar
operations are done in string, like converting a string to Uppercase/lowercase, trimming the spaces in front & back, 
length, checking the index of fragment and much more -->

<h1>Playing with Function tags</h1>
<div class="input-section">

<x:out value="Hi ${name}, Welcome to Function tags"/>

<x:set var="coreVar" value=" I'm still a learner " scope="page"/><br/>
<x:out value=" The variable set using core tag -> '${coreVar}'"/><br/>

<x:out value="The length of string is ${fn:length(coreVar)}"/><br/>

<x:out value="After trimming the string -> '${fn:trim(coreVar)}' with length ${fn:length(fn:trim(coreVar))}"/><br/>

<x:if test="${fn:contains(coreVar,'still')}">
	<x:out value="Inside the core if tag, passing if test"/>
	<x:out value="The if test for function containing fragment of '${coreVar}' 
	is ${fn:contains(coreVar,'still')}"/>
</x:if>

<x:forEach items="${fn:split(coreVar, ' ')}" var="splitter">
	<br/>
	${fn:length(splitter)} :  ${splitter}
</x:forEach><br/>

<x:out value="Ending string check-> ${fn:endsWith(coreVar,'learner ')} where index of 
letter 'a' is ->${fn:indexOf(coreVar,'a') }"/>

</div>
	
</body>
</html>