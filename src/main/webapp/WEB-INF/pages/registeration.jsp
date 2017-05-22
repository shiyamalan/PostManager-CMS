<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/common/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register New Editor</title>
<link rel="stylesheet" href="resources/css/registeration.css"
	type="text/css" />

<link rel="stylesheet" href="resources/css/navigation.css"
	type="text/css" />
<link rel="stylesheet" href="resources/css/registeration.css"
	type="text/css" />
</head>
<body>
	<ul class="topnav">
		<li><a href="admin"> <i class="fa fa-user"></i>
				Home(Administration)
		</a></li>
		<li><a href="users"> <i class="fa fa-user"></i> Users
		</a></li>
		<li><a href="../../logout"><i class="fa fa-user"></i> Logout
		</a></li>
	</ul>
	<h1 class="register-title">Register a New Editor to CMS</h1>
	<form:form class="register" method="post" modelAttribute="user"
		action="${pageContext.request.contextPath}/register">

		<font color="red" class="w3-centered">${message}</font>
		<spring:bind path="username">
			<div class="form-group row  ${status.error ? 'has-error' : ''}">
				<label for="example-text-input" class="col-xs-2 col-form-label">Username</label>
				<div class="col-xs-10">
					<form:input path="username" class="form-control" type="text"
						value="" id="username" />
					<form:errors path="username" class="control-label" />
				</div>
			</div>
		</spring:bind>
		<div class="form-group row ${status.error ? 'has-error' : ''}">
			<label for="example-password-input" class="col-xs-2 col-form-label">Password</label>
			<div class="col-xs-10">
				<form:input path="password" class="form-control" type="password"
					value="" id="password" />
				<form:errors path="password" class="control-label" />
			</div>
		</div>
		<input type="submit" value="Create Account" class="register-button">
	</form:form>
</body>
</html>