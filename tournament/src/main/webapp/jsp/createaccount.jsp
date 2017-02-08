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

</body>
</html>