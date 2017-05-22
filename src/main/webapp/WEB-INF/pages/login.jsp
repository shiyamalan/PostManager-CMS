<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/common/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="resources/css/login.css" type="text/css" />
<link rel="stylesheet" href="resources/css/registeration.css"
	type="text/css" />
<title>Login Page</title>
</head>
<body>
	

	<div class="login-page">
		<div class="form">
		<font color="red" class = "w3-centered">${message}</font>
			<form:form class="login-form" id="loginForm" method="post"
				action="login" modelAttribute="user">

				<form:label path="username">Enter your user-name</form:label>
				<form:input id="username" name="username" path="" />
				<br>
				<form:label path="username">Please enter your password</form:label>
				<form:password id="password" name="password" path="" />
				<br>
				<input type="submit" value="Sign In" />
			</form:form>
		</div>
	</div>
	<%-- <div class="login-page">
		<div class="form">
			<form:form class="register-form" action="login" modelAttribute="user" method=post>
				<input type="text" placeholder="username"  name = "username"/> <input type="password"
					placeholder="password" name="password"/> 
					<input type="text"
					placeholder="email address" />
				<button>create</button>
				<p class="message">
					Already registered? <a href="#">Sign In</a>
				</p>
			</form:form>
			<form:form class="login-form" action="login" modelAttribute="user" method=post>
				<form:input type="text" placeholder="username" /> <input type="password"
					placeholder="password" />
				<button type="submit">Login</button>
				<p class="message">
					Not registered? <a href="#">Create an account</a>
				</p>
			</form:form>
		</div>
	</div> --%>
</body>
</html>