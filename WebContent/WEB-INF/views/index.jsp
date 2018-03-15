<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<!-- Add this for bootstrap; set utf-8; and add scripts at bottom of body -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="resources\\styles.css" rel="stylesheet" />
<!-- links to our stylesheet -->
<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'>
<!-- <link rel="image_src" href="https://s-i.huffpost.com/gen/1878403/images/o-DETROIT-facebook.jpg" />
<meta itemprop="image" content="https://s-i.huffpost.com/gen/1878403/images/o-DETROIT-facebook.jpg" /> -->

<title>ZabavaQuest Home</title>

</head>
<body>
	<div id="indexdiv">

		<div class="video-background">
			<div class="video-foreground">
				<iframe
					src="https://www.youtube.com/embed/UWDsrIBeXqM?controls=0&showinfo=0&rel=0&autoplay=1&loop=1&mute=1&playlist=UWDsrIBeXqM"
					frameborder="0" allowfullscreen></iframe>
			</div>
		</div>

		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-static-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span> <span class="icon-bar"></span>
					</button>

					<a class="navbar-brand" href="./">ZabavaQuest</a>
				</div>
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav navbar-right">

						<li><a href="https://zabavaquest.com/adminlogin">Create</a></li>
						<li><a href="About.jsp">About</a></li>
					</ul>
				</div>
			</div>
		</nav>

		<div class="container" id="indexcontainer">
			<div class="jumbotron" id="indexjumbotron">
				<h1>ZabavaQuest</h1>
				<br>
				<h2>Enter your QuestCode here:</h2>
				<form action="quest" method="post">
					<p>
						<input type="text" name="code" style="text-transform: uppercase" />
						<!--  <input type="submit" Value="Submit"> -->
						<input type="submit" class="btn btn-primary" value="Submit">
					</p>
				</form>
				<br>
			</div>
		</div>

		<!-- 		<div style="text-align: center"> -->

		<c:set var="codevalid" value="${valid}" />
		<c:if test="${codevalid == false}">

			<div class="editing-well">
				<div style="text-align: center">
					<h3>${failmssg}</h3>
				</div>
		</c:if>
	</div>

	<!-- add these for Bootstrap -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</div>
</body>
</html>