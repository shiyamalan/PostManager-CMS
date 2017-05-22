<%@ include file="/common/include.jsp"%>
<head>
<title>Preview</title>
<link rel="stylesheet" href="../../resources/css/navigation.css"
	type="text/css" />
</head>

<body>
	<ul class="topnav" role="tablist">
		<li><a href="#"> <i class="fa fa-user"></i> Image Preview
		</a></li>
		<li><a href="../../main" role="tab" data-toggle="tab"> <i
				class="fa fa-user"></i> Home
		</a></li>
		<li><a href="../../logout"><i class="fa fa-user"></i> Logout
		</a></li>
	</ul>
	<div style="height: 600px; overflow: auto;">
		<div id="wrapper" class="fill">
			<div class="fill" align="center">
				<br>
				<div class="cover">
					<h1>${post.title}</h1>
					<img src="image/${post.blog_post_id}" />
				</div>
				<div class="content well">
					<h3>${post.content}</h3>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		/* 	document.getElementById("bannerimage").src = "data:image/png;base64,"
					+ $
			{
				post.imageSrc
			}; */
	</script>

</body>

