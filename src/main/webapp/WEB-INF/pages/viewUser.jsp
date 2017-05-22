<%@ include file="/common/include.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Title</title>
<script src="//cdn.tinymce.com/4/tinymce.min.js"></script>
<script>
	tinymce.init({
		selector : 'textarea'
	});
</script>
<link rel="stylesheet" href="resources/css/theme.css">

<style>
.button {
	background-color: #4CAF50; /* Green */
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	margin: 4px 2px;
	cursor: pointer;
}

.addButton {
	font-size: 24px;
}
</style>
</head>
<body>
	<div id="w3-contatiner">


		<div>
			<c:if test="${!empty posts}">
				<table class="w3-table w3-striped " style="">
					<thead>
						<tr>
							<th width="100">Post ID</th>
							<th width="200">Post Title</th>
							<th width="100">Post Created At</th>
							<th width="100">Post Author</th>
							<th width="80">Post PreView</th>
							<th width="80">Post Status</th>
						</tr>
					</thead>
					<c:forEach items="${posts}" var="post">
						<tbody>
							<tr>
								<td>${post.blog_post_id}</td>
								<td>${post.title}</td>
								<td>${post.created}</td>
								<td>${post.username}</td>
								<td><a href="<c:url value='/post/preview/${post}' />">Edit</a></td>
								<td><a href="<c:url value='/post/edit/${person.id}' />">Delete</a></td>
								<td><select>
										<option value="1">Draft</option>
										<option value="3">Ready to publish</option>
								</select></td>
							</tr>
						</tbody>
					</c:forEach>


				</table>
			</c:if>
		</div>
	</div>

	<div>
		<button class="button addButton">25px</button>
	</div>
</body>
</html>
