<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/common/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users in CMS</title>
<link rel="stylesheet" href="resources/css/theme.css" type="text/css" />
<link rel="stylesheet" href="resources/css/navigation.css"
	type="text/css" />
</head>
<body>
	<div>
		<ul class="topnav">
			<li><a href="admin"> <i class="fa fa-user"></i> Admin Window
			</a></li>
			<li><a href="logout"> <i class="fa fa-user"></i> Logout
			</a></li>

			<li><a href="register"> <i class="fa fa-user"></i> Register
					Editor
			</a></li>


		</ul>
	</div>
	<div class="tab-pane fade" id="editors">
		<h2 class = "w3-centered">Active and Suspended User List</h2>
		<table class="w3-table-all w3-striped w3-centered w3-hoverable">

			<thead>
				<tr>
					<th width="80">User Name</th>
					<th width="80">Enable/ Disable</th>
				</tr>
			</thead>
			<c:forEach var="user" items="${userList}">
				<tr>
					<td>${user.username}</td>
					<td><c:choose>
							<c:when test="${user.enabled}">
								<button name="suspend" value="${user.username}"
									class="btn btn-info"
									onclick="location.href='${pageContext.request.contextPath}/user/suspend?suspend=${user.username}&enabled=${user.enabled}'">Suspend</button>
							</c:when>
							<c:otherwise>
								<button name="suspend" value="${user.username}"
									class="btn btn-info"
									onclick="location.href='${pageContext.request.contextPath}/user/suspend?suspend=${user.username}&enabled=${user.enabled}'">Enable</button>
							</c:otherwise>
						</c:choose></td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>