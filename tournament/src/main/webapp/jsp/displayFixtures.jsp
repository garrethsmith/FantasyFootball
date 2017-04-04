<%@page import="com.fantasy.model.Fixtures"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Displaying Fixtures</title>
	<jsp:directive.include file="includes/styles.jsp" />
	
	<style type="text/css">
		td {width:175px}
	</style>
</head>
<body>

	<jsp:directive.include file="includes/header.jsp" />
	
	<div class="container">
		<main class="row">
	
			<c:if test="${!empty user}">
			
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
				
			</c:if>
		</main>
	</div>

</body>
</html>