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
				<div class="row">
					<div class="col-xs-2">
						<p>First name</p>
					</div>
					<div class="col-xs-10">
						<p><form:input type="text" path="firstname" name="firstname" /></p>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-2">&nbsp;</div>
					<div class="col-xs-10">
						<p><form:errors path="firstname" cssClass="error" /></p>
					</div>
				</div>
				
				
				<div class="row">
					<div class="col-xs-2">
						<p>Surname</p>
					</div>
					<div class="col-xs-10">
						<p><form:input type="text" path="surname" name="surname" /></p>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-1">&nbsp;</div>
					<div class="col-xs-11">
						<p><form:errors path="surname" cssClass="error" /></p>
					</div>
				</div>
				
				<div class="row">
					<div class="col-xs-2">
						<p>Team name</p>
					</div>
					<div class="col-xs-10">
						<p><form:input type="text" path="teamname" name="teamname" /></p>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-2">&nbsp;</div>
					<div class="col-xs-10">
						<p><form:errors path="teamname" cssClass="error" /></p>
					</div>
				</div>
				
				<div class="row">
					<div class="col-xs-2">
						<p>email</p>
					</div>
					<div class="col-xs-10">
						<p><form:input type="text" path="email" name="email" /></p>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-2">&nbsp;</div>
					<div class="col-xs-10">
						<p><form:errors path="email" cssClass="error" /></p>
					</div>
				</div>
				
				<div class="row">
					<div class="col-xs-2">&nbsp;</div>
					<div class="col-xs-10">
						<p><input type="submit" value="create" /></p>
					</div>
				</div>
			</form:form>
		</main>
	</div>
</body>
</html>