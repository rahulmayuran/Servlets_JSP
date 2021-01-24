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

<table>

<tr><td><x:out value="Hi ${name}, Welcome to Function tags"/></td></tr>

<x:set var="coreVar" value=" I'm still a learner " scope="page"/>

<tr><td><x:out value=" The variable set using core tag -> '${coreVar}'"/></td></tr>

<tr><td><x:out value="The length of string is ${fn:length(coreVar)}"/></td></tr>

<tr><td><x:out value="After trimming the string -> '${fn:trim(coreVar)}' with length ${fn:length(fn:trim(coreVar))}"/></td></tr>

<tr><td><x:if test="${fn:contains(coreVar,'still')}">
	<x:out value="Inside the core if tag, passing if test"/>
	<x:out value="The if test for function containing fragment of '${coreVar}' 
	is ${fn:contains(coreVar,'still')}"/>
</x:if></td></tr>

<tr><td><x:set var="UpperVar" value=" I'M STILL A LEARNER " scope="session"/>
<x:choose>
<x:when test="${fn:toUpperCase(coreVar) == UpperVar}">
		<x:out value="Inside when tag, The variable set with Uppercase and function tag validation matched"></x:out>
	</x:when>
	<x:otherwise>
		<x:out value="The Uppercase convertion had some issues"></x:out>
	</x:otherwise>
</x:choose></td></tr>


<tr><td><x:choose>
	<x:when test="${fn:indexOf(coreVar, 'a') == 11}">
		<x:out value="Inside the when tag,The index of a in the set variable with the condition is true"></x:out>
	</x:when>
	<x:otherwise>
		<x:out value="The index is not equal"></x:out>
	</x:otherwise>
</x:choose></td></tr>

<tr><td><x:out value="Ending string check-> ${fn:endsWith(coreVar,'learner ')} where index of 
letter 'a' is ->${fn:indexOf(coreVar,'a') }"/></td></tr>

</table>

<br/>

<table>
	<tr>
		<th>Length</th>
		<th>String value</th>
	</tr>
<x:forEach items="${fn:split(coreVar, ' ')}" var="splitter">
	<tr>
		<td>${fn:length(splitter)}</td>
		<td>${splitter}</td>	
	</tr>
</x:forEach>
</table>



</div>
	
</body>
</html>