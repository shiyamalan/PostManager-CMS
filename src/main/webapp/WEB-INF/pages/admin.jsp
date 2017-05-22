<%@ include file="/common/include.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title><fmt:message key="Admin Control Panel" /></title>
<link rel="stylesheet" href="resources/css/theme.css" type="text/css" />
<link rel="stylesheet" href="resources/css/navigation.css"
	type="text/css" />
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}
</style>
</head>

<body>
	<ul class="topnav" role="tablist">
		<li><a href="admin" role="tab" data-toggle="tab"> <i
				class="fa fa-user"></i> Admin Window
		</a></li>
		<li><a href="users"> <i class="fa fa-user"></i> Users
		</a></li>
		<li><a href="register"> Register New Editor </a></li>
		<li><a href="logout" role="tab" data-toggle="tab"> <i
				class="fa fa-user"></i> Logout
		</a></li>
	</ul>

	<div class="w3-centered" id="home">
		<c:if test="${not empty msg}">
			<div id="success-alert" class="alert alert-success alert-dismissible">
				<button type="button" class="close" data-dismiss="alert"
					aria-hidden="true">x</button>
				<h4>
					<i class="icon fa fa-check"></i> User Created!
				</h4>
				User created successfully.
			</div>
		</c:if>
		<c:if test="${not empty error}">
			<div id="success-alert" class="alert alert-error alert-dismissible">
				<button type="button" class="close" data-dismiss="alert"
					aria-hidden="true">x</button>
				<h4>
					<i class="icon fa fa-check"></i> Error While Creating User!
				</h4>
				${error}
			</div>
		</c:if>

	</div>

	<div class="w3-centered" style="overflow-x: auto;">
		<c:if test="${!empty posts}">

			<h2>All Post posted by Editors</h2>
			<table class="w3-bordered w3-table-all">
				<thead class="w3-centered">
					<tr>
						<th width="100">Post ID</th>
						<th width="200">Post Title</th>
						<th width="100">Post Created At</th>
						<th width="100">Page Author</th>
						<th width="100">Post Status</th>
						<th width="80">Post PreView</th>
						<th width="80">Post Status</th>
					</tr>
				</thead>
				<c:forEach items="${posts}" var="post">
					<tbody class="w3-centered w3-bordered">
						<tr>
							<td id="post_id">${post.blog_post_id}</td>
							<td>${post.title}</td>
							<td>${post.created}</td>
							<td>${post.username}</td>
							<td>${post.status}</td>
							<td><a
								href="<c:url value='/post/preview/${post.blog_post_id}'/>">Preview</a></td>
							<%-- 	<td><a href="<c:url value='/post/edit/${post.blog_post_id}' />">Preview</a></td> --%>

							<td><form:form class="" action="post/state" method="POST">
									<input type="hidden" name="id" value="${post.blog_post_id}"
										readonly="readonly" />
									<input type="hidden" name="date" id="date"
										value="${post.publish}">
									<button type="submit" class="w3-button">Change Status</button>
								</form:form> <form:form action="post/edit/${post.blog_post_id}" method="GET">
									<button type="submit" class="w3-button">Edit Post</button>
								</form:form></td>
						</tr>
					</tbody>
				</c:forEach>


			</table>
		</c:if>
	</div>

	<script>
		jQuery(document).ready(function($) {
			//        if($('#username').val() == '' || $('#password').val() == ''){
			//            $('#c-editor').prop("disabled",true);
			//        } else {
			//            $('#c-editor').prop("disabled",false);
			//        }

			//        $(document.body).on('input', '#username,#password' ,function(){
			//            if($('#username').val() == '' || $('#password').val() == ''){
			//                $('#c-editor').prop("disabled",true);
			//            } else {
			//                $('#c-editor').prop("disabled",false);
			//            }
			//        });

			$("#success-alert").fadeTo(2000, 500).slideUp(500, function() {
				$("#success-alert").alert('close');
			});

		});
	</script>
</body>
</html>
