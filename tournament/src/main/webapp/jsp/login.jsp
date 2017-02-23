<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin: Create new user account</title>

<style type="text/css">
	.error { color: red; font-size: 15px; }
</style>
</head>
<body>

<h1>Login fool... </h1>

<form:form commandName="login" method="post" action="displayFixtures.html">	
	<p>Username: <form:input type="text" path="username" name="username" />
	<form:errors path="username" cssClass="error" /></p>
	<p>Password: <form:input type="text" path="password" name="password" />
	<form:errors path="password" cssClass="error" /></p>
	<p><input type="submit" value="create" /></p>
</form:form>

</body>
</html>