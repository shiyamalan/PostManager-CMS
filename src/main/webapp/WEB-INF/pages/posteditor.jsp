<%@ include file="/common/include.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Edit the Post</title>

<link rel="stylesheet" href="../../resources/css/theme.css">
<script src="//cdn.tinymce.com/4/tinymce.min.js"></script>
<link rel="stylesheet" href="../../resources/css/navigation.css"
	type="text/css" />
<script>
	tinymce.init({
		selector : 'textarea'
	});
</script>
</head>
<body>
	<ul class="topnav" role="tablist">
		<li><a href="../../main" role="tab" data-toggle="tab"> <i
				class="fa fa-user"></i> Home
		</a></li>
		<li><a href="../../logout" role="tab" data-toggle="tab"> <i
				class="fa fa-user"></i> Logout
		</a></li>
	</ul>
	
	<form:form class="w3-centered" method="post"
		action="${pageContext.request.contextPath}/post/edit"
		enctype="multipart/form-data" modelAttribute="post">
		<h1>Enter New Post Information in given field</h1>
		<table class="w3-table w3-striped" style="width: 80%;">
			<tr>
				<td><h3>Enter Post Title</h3></td>
			</tr>
			<tr>
				<td><form:hidden path="blog_post_id" /> <form:input
						style="width: 80%;" id="post-title" path="title"
						placeHolder="Enter Post Title" name="post-title"
						value='${post.title}'></form:input> <br /></td>
			</tr>
			<tr>
				<td><br /></td>
			</tr>

			<tr>
				<td><h3>Please select cover image to upload</h3></td>
			</tr>
			<tr>
				<td><input id="post-file" type="file" name="image" /></td>
			</tr>

			<tr>
				<td><br /></td>
			</tr>
			<tr>

				<td>
					<div style="width: 100%;">
						<textarea class="ckeditor" name="content" id="post-content"
							cols="35" rows="10"><c:out value="{$post.content}" />
						</textarea>

					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div id="rich-text-btn-group" class="w3-container">
						<button id="preview-button" type="submit" name="action"
							value="preview" class="w3-button">Preview</button>
						<button id="drafts-button" type="submit" name="action"
							value="draft" class="w3-button">Save as Drafts</button>
						<button id="rp-button" type="submit" name="action"
							class="w3-button" value="publish">Ready to Publish?</button>
					</div>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>
