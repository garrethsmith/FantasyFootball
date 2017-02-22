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
	th {width:125px}
</style>
</head>
<body>
	
	<h1>My predictions</h1>
	
	<table>
		<tr>
			<th>User</th>
			<c:forEach var="fixture" items="${fixtures}">
				<th><c:out value="${fixture.homeTeam}" /> vs <c:out value="${fixture.awayTeam}" /><br/>
					<c:out value="${fixture.kickOff}" /></th>
			</c:forEach>
		</tr>
		<tr>
			<td><c:out value="${user.firstname}" /></td>
			<c:forEach var="fixture" items="${fixtures}">
				<td>
					<c:set var="flag" value="false" />
					<c:forEach var="prediction" items="${fixture.predictions}">
						<c:choose>
	  						<c:when test="${prediction.id == user.id}">
	  							<c:set var="flag" value="true" />
	  							<p><c:out value="${prediction.prediction}" /></p>
							</c:when>
						</c:choose>
					</c:forEach>
					<c:if test="${!flag}">
						<c:set var="flag" value="false" />
						<p>n/a</p>
					</c:if>	
				</td>
			</c:forEach>
		</tr>
		<c:forEach var="u" items="${users}">
			<tr>
				<td><c:out value="${user.firstname}" /></td>
				<c:forEach var="fixture" items="${fixtures}">
					<td>
						<c:forEach var="prediction" items="${fixture.predictions}">
							<c:choose>
		  						<c:when test="${prediction.id == u.id}">
		  							<c:set var="flag" value="true" />
		  							<p><c:out value="${prediction.prediction}" /></p>
								</c:when>
							</c:choose>
						</c:forEach>
						<c:if test="${!flag}">
							<c:set var="flag" value="false" />
							<p>n/a</p>
						</c:if>
					</td>	
				</c:forEach>
			</tr>
		</c:forEach>
	</table>

</body>
</html>