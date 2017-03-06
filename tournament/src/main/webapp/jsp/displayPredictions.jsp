<%@page import="com.fantasy.model.Fixtures"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Displaying Fixtures</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	
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
		
		td.userprediction { background: #e3f0f4; }
		td.userpredictionchange { background: #ffa500; }
	</style>
	
	<script type="text/javascript">
	
		$(document).ready (function () {			
			var userpredictions = document.getElementsByClassName("userprediction");
			for (var i=0; i<userpredictions.length; i++) {
				userpredictions[i].addEventListener('focusout', updateScore, false);
			}
		})
		
		function updateScore () {
			$("div#results").append("<p>Posting User/Game ID "  + this.id + " Value " + this.value + "</p>");
			
			var prediction = {}
			prediction["id"] = this.id;
			prediction["value"] = this.value;
			
			JSON.stringify(prediction);
				
			$.ajax({
				type : "POST",
				url : "/tournament/setPredictionString.html",
				data : prediction,
				timeout : 100000,
				success : function(data) {
					console.log("SUCCESS: ", data);
					displayResult(data, "success");
				},
				error : function(e) {
					console.log("ERROR: ", e);
					displayResult(e, "error");
				},
				done : function(e) {
					console.log("DONE");
					displayResult(true, "done");
				}
			});
		}
		
		function displayResult (result, from) {
			$("div#results").append("<p>Ajax call made from "  + from + " Result " + result + "</p>");
		}
		
	</script>
	
</head>
<body>

	<c:choose>
	  	<c:when test="${empty user}">
	  		<p>Please <a href="login.html">login</a></p>
		</c:when>
		<c:otherwise>
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
								<p id='<c:out value="${user.id}" />-<c:out value="${fixture.gameid}" />' class="noprediction">n/a</p>
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
		</c:otherwise>
	</c:choose>
	<p>&nbsp;</p>
	<div id="results"></div>

</body>
</html>