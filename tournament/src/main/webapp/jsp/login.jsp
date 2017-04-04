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
					<p>Username: <form:input type="text" path="username" name="username" />
					<form:errors path="username" cssClass="error" /></p>
					<p>No password needed for now</p>
					<p>Password: <form:input type="text" path="password" name="password" />
					<form:errors path="password" cssClass="error" /></p>
					<p><input type="submit" value="create" /></p>
				</form:form>
			
			</div>
	
		</main>
	</div>

</body>
</html>