<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Admin: Create new user account</title>
	<jsp:directive.include file="includes/styles.jsp" />
	
	<style type="text/css">
		.error { color: red; font-size: 15px; }
	</style>
</head>
<body>

	<jsp:directive.include file="includes/header.jsp" />

	<div class="container">
		<main class="row">
		
			<h1>Login fool... </h1>
			
			<div class="col-xs-12">
			
				<form:form commandName="login" method="post" action="displayFixtures.html">	
					<div class="row">
						<div class="col-xs-1">
							<p>Username:</p>
						</div>
						<div class="col-xs-11">
							<p><form:input type="text" path="username" name="username" /></p>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-1">&nbsp;</div>
						<div class="col-xs-11">
							<p><form:errors path="username" cssClass="error" /></p>
						</div>
					</div>
						 
					<div class="row ">
						<div class="col-xs-1">&nbsp;</div>
						<div class="col-xs-11">
							<p>No password needed for now</p>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-1">
							<p>Password:</p>
						</div>
						<div class="col-xs-11">
							<p><form:input type="text" path="password" name="password" /></p>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-1">&nbsp;</div>
						<div class="col-xs-11">
							<p><form:errors path="password" cssClass="error" /></p>
						</div>
					</div>
					
					
					<div class="row">
						<div class="col-xs-1">&nbsp;</div>
						<div class="col-xs-11">
							<p><input type="submit" value="Sign in" class="btn btn-primary" /></p>
						</div>
					</div>
				</form:form>
			
			</div>
	
		</main>
	</div>

</body>
</html>