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
</head>
<body>

	<jsp:directive.include file="includes/header.jsp" />

	<c:choose>
	  	<c:when test="${empty user}">
	  		<p>&nbsp;</p> <!-- Change to if user not empty -->
		</c:when>
		<c:otherwise>
		
			<div class="container">
		        <main class="row">
		        	<article class="col-xs-12">
			
						<h2>My predictions</h2>
					
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
							<tr class="userrow">
								<td><c:out value="${user.firstname}"/></td>
								<c:forEach var="fixture" items="${fixtures}">
									<td class="userrow">
										<c:set var="flag" value="false" />
										<c:forEach var="prediction" items="${fixture.predictions}">
											<c:choose>
						  						<c:when test="${prediction.id == user.id}">
						  							<c:set var="flag" value="true" />
													<input id="<c:out value="${user.id}" />-<c:out value="${fixture.gameid}" />" class="userprediction" value="<c:out value="${prediction.prediction}" />" />
												</c:when>
											</c:choose>
										</c:forEach>
										<c:if test="${!flag}">
											<c:set var="flag" value="false" />
											<!-- <p id='<c:out value="${user.id}" />-<c:out value="${fixture.gameid}" />' class="noprediction">n/a</p> -->
											<input id="<c:out value="${user.id}" />-<c:out value="${fixture.gameid}" />" class="userprediction" value="<c:out value="${prediction.prediction}" />" />
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
									  						<p id='<c:out value="${u.id}" />-<c:out value="${fixture.gameid}" />'><strong><c:out value="${prediction.prediction}" /></strong></p>
														</c:when>
													</c:choose>
												</c:forEach>
												<c:if test="${!flag}">
													<p  id='<c:out value="${u.id}" />-<c:out value="${fixture.gameid}" />' class="noprediction">n/a</p>
												</c:if>
											</td>	
										</c:forEach>
									</tr>
								</c:if>
							</c:forEach>
						</table>
						
						<div class="row">  
							<p>&nbsp;</p>
							<button type="button" id="resetLog" class="btn btn-primary">Reset log</button>
							<div id="results"></div>
						</div>
							
		        	</article>
		        </main>
		    </div>
		</c:otherwise>
	</c:choose>

</body>
</html>