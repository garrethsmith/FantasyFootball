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
		table { color: #333; 
			width: 98%;
			border-collapse:
			collapse; border-spacing: 0;
		}
			
		td, th { border: 1px solid #CCC; 
			height: 30px; } 
			
		.firstcol { width: 100px; }
		
		.noprediction { color: #C0C0C0; }
			
		th { background: #F3F3F3; 
			font-weight: bold;
		}
			
		td { background: #FAFAFA;
			text-align: center; 
		}
	</style>
</head>
<body>
	
	<h1>My predictions</h1>
	
	<table>
		<tr>
			<th class="firstcol">User</th>
			<c:forEach var="fixture" items="${fixtures}">
				<th><c:out value="${fixture.homeTeam}" /> vs <c:out value="${fixture.awayTeam}" /></th>
			</c:forEach>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<c:forEach var="fixture" items="${fixtures}">
				<td><c:out value="${fixture.kickOff}" /></td>
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
	  							<p><strong><c:out value="${prediction.prediction}" /></strong></p>
							</c:when>
						</c:choose>
					</c:forEach>
					<c:if test="${!flag}">
						<c:set var="flag" value="false" />
						<p class="noprediction">n/a</p>
					</c:if>	
				</td>
			</c:forEach>
		</tr>
		<c:forEach var="u" items="${users}">
		  	<c:if test="${user.id != u.id}">
				<tr>
					<td><c:out value="${u.firstname}" /></td>
					<c:forEach var="fixture" items="${fixtures}">
						<c:set var="flag" value="false" />
						<td>
							<c:forEach var="prediction" items="${fixture.predictions}">
								<c:choose>
			  						<c:when test="${prediction.id == u.id}">
				  						<c:set var="flag" value="true" />
				  						<p><strong><c:out value="${prediction.prediction}" /></strong></p>
									</c:when>
								</c:choose>
							</c:forEach>
							<c:if test="${!flag}">
								<p class="noprediction">n/a</p>
							</c:if>
						</td>	
					</c:forEach>
				</tr>
			</c:if>
		</c:forEach>
	</table>

</body>
</html>