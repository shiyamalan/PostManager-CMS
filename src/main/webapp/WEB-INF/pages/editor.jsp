<%@ include file="/common/include.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Add New Post</title>

<link rel="stylesheet" href="../resources/css/theme.css">
<script src="//cdn.tinymce.com/4/tinymce.min.js"></script>
<script>
	tinymce.init({
		selector : 'textarea'
	});
</script>

<link rel="stylesheet" href="../resources/css/navigation.css"
	type="text/css" />
</head>
<body>
	<ul class="topnav" role="tablist">
		<li><a href="../editor" role="tab" data-toggle="tab"> <i
				class="fa fa-user"></i> Home(Editor)
		</a></li>
		<li><a href="../logout" role="tab" data-toggle="tab"> <i
				class="fa fa-user"></i> Logout
		</a></li>
	</ul>
	<div class="w3-centeer">
		<h3>Enter New Post Information in given field</h3>
	</div>
	<form:form class="w3-centered" method="post" modelAttribute="post"
		action="../post/create/">

		<table class="w3-table w3-striped" style="width: 80%;">
			<tr>
				<td><h3>Post Title</h3></td>
			</tr>
			<tr>
				<td><form:hidden path="blog_post_id" /> <form:input
						style="width: 80%;" id="post-title" path="title"
						placeHolder="Enter Post Title" name="title"></form:input> <br /></td>
			</tr>
			<tr>
				<td><br /></td>
			</tr>

			<tr>
				<td><h3>Select a post banner image to upload</h3></td>
			</tr>
			<tr>
				<td><form:input id="post-file" type="file" name="image"
						path="image" /></td>
			</tr>

			<tr>
				<td><br /></td>
			</tr>
			<tr>
				<td>
					<div style="width: 100%;">
						<textarea class="ckeditor" name="content" id="post-content"
							cols="35" rows="10">
						</textarea>

					</div>
				</td>
			</tr>
			<tr>
				<td>
					<h3>Select the status of Post</h3> <form:select id="status"
						path="statusID" onclick="GetSelectedItem('status')"
						class="w3-dropdown w3-select">
						<option value="1">Preview (You can view the web page
							before saving)</option>
						<option value="2">Draft (You can save post as draft)</option>
						<option value="3">Ready to Publish(The post set to ready
							for publish)</option>
					</form:select>
				</td>
			</tr>
			<tr>
				<td>
					<button class="w3-button" type="submit" id="submitBtn">Press
						Here</button>
				</td>
			</tr>
		</table>
	</form:form>
	<script type="text/javascript">
		function GetSelectedItem(e0) {
			var e = document.getElementById(e0);
			var strSel = "The Value is: " + e.options[e.selectedIndex].value
					+ " and text is: " + e.options[e.selectedIndex].text;
			post.statusID = e.options[e.selectedIndex].value;
		}
	</script>
</body>

</html>
