<%@page import="com.fantasy.model.Fixtures"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>DAdmin: Create new user account</title>
	<jsp:directive.include file="includes/styles.jsp" />
	<style type="text/css">
		td {width:175px}
	</style>
</head>
<body>

	<jsp:directive.include file="includes/header.jsp" />

	<div class="container">
		<main class="row">
		
			<h1>Create new user account</h1>
			
			<form:form commandName="account" method="post" action="accountcreated.html">	
				<p>First name: <form:input type="text" path="firstname" name="firstname" />
				<form:errors path="firstname" cssClass="error" /></p>
				<p>Surname: <form:input type="text" path="surname" name="surname" />
				<form:errors path="surname" cssClass="error" /></p>
				<p>Team name: <form:input type="text" path="teamname" name="teamname" />
				<form:errors path="teamname" cssClass="error" /></p>
				<p>email: <form:input type="text" path="email" name="email" />
				<form:errors path="email" cssClass="error" /></p>
				<p><input type="submit" value="create" /></p>
			</form:form>
		</main>
	</div>
</body>
</html>