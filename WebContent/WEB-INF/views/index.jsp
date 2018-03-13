<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="resources\\styles.css" rel="stylesheet" />
<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'>

<title>Zabava Quest Home</title>

</head>
<body>

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
				<a class="navbar-brand" href="/">ZabavaQuest</a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">About</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Services<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Design</a></li>
							<li><a href="#">Development</a></li>
							<li><a href="#">Consulting</a></li>
						</ul></li>
					<li><a href="#">Contact</a></li>
					<li><a href="enter">Admin</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="jumbotron">
		<div class="container">
			<h1>ZabavaQuest</h1>
			<p>Are you ready to boilerstrap your cross-compatible buzzword?
				It's Sassy, flat and semantic, so what are you waiting for?</p>
			<br>
			<p>
				<a class="btn btn-primary btn-lg" href="#" role="button">Download
					Free Trial »</a> <a class="btn btn-primary btn-lg" href="#"
					role="button">Learn more »</a>
			</p>
		</div>
	</div>

	<div class="container-fluid">
		<div style="text-align: center">
			<h1>Bootstrap test</h1>
			<p>This is some text.</p>
			<img src="resources\\FFcharacter.JPG" alt="it's an image" width="70">
		</div>
	</div>
	<br>
	<div style="text-align: center">
		<h2>Welcome to ZabavaQuest!</h2>
		<br> <br>
		<h3>
			<form action="quest" method="post">
				Enter your QuestCode here: <input type="text" name="code"> <input
					type="submit" Value="Submit">
			</form>
			<br>
		</h3>
		<c:set var="codevalid" value="${valid}" />
		<c:if test="${codevalid == false}">
			<p>
				<img src="resources\\mean-git.png" alt="bad job" width="50">${failmssg}</p>
		</c:if>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<span class="glyphicon glyphicon-cloud" aria-hidden="true"></span>
				<h3>Cloud Computable</h3>
				<p>Donec id elit non mi porta gravida at eget metus. Fusce
					dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh.</p>
			</div>
			<div class="col-md-4">
				<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>
				<h3>Backwards Compatible</h3>
				<p>Etiam porta sem malesuada magna mollis euismod. Donec sed
					odio dui. Lorem ipsum dolor.</p>
			</div>
			<div class="col-md-4">
				<span class="glyphicon glyphicon-console" aria-hidden="true"></span>
				<h3>GUI Free</h3>
				<p>Vestibulum id ligula porta felis euismod semper. Fusce
					dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh.</p>
			</div>
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>