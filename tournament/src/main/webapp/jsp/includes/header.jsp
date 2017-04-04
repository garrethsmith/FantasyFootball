<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
	
<nav class="navbar navbar-default">
	<div class="container-fluid">
    	<div class="navbar-header">
    		<a class="navbar-brand" href="displayFixtures.html">Fantasy Tournament Football</a>
		</div>
    	
			<div class="collapse navbar-collapse">
				<c:if test="${!empty user}">
					<ul class="nav navbar-nav">
						<li><a href="displayFixtures.html">Display Fixtures</a></li>
						<li><a href="displayPredictions.html">Predictions</a></li>
					</ul>
				</c:if>
				
				<ul class="nav navbar-nav navbar-right">
		        	<c:choose>
					  	<c:when test="${empty user}">
					  		<li><a href="login.html">Please login</a></li>
							<li><a href="createaccount.html">Create account</a></li>
						</c:when>
						<c:otherwise>
							<li><a>Signed in as ${user.firstname}</a></li>
						</c:otherwise>
					</c:choose>
		        </ul>
			</div>
	</div>
</nav>