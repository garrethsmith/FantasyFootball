<%@page import="com.fantasy.model.Fixtures"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Displaying Fixtures</title>
<style type="text/css">
	td {width:175px}
</style>
</head>
<body>

<h1>Display fixtures</h1>

<table>
	<tr>
		<td>Fixture</td>
		<td>Kick Off</td>
		<td>Result</td>
		<td>Round</td>
	</tr>
	<c:forEach var="fixture" items="${fixtures.fixtures}">
		<tr>
			<td><c:out value="${fixture.homeTeam}" /> v <c:out value="${fixture.awayTeam}" /></td>
			<td><c:out value="${fixture.kickOff}" /></td>
			<td><c:out value="${fixture.matchResult}" /></td>
			<td><c:out value="${fixture.round}" /></td>
		</tr>
	</c:forEach>
</table>



</body>
</html>