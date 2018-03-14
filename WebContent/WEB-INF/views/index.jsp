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

<title>ZabavaQuest Home</title>

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
				<a class="navbar-brand" href="index">ZabavaQuest</a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">About</a></li>
					<li><a href="enter">Create</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">
		<div class="jumbotron">
			<h1>ZabavaQuest</h1>
			<br>
			<h2>Enter your QuestCode here:</h2>
			<form action="quest" method="post">
				<p>
					<input type="text" name="code" style="text-transform: uppercase" />
					<!--  <input type="submit" Value="Submit"> -->
					<input type="submit"
						class="btn btn-primary" value="Submit">
				</p>
			</form>
			<br>
<!-- 			<p>
				<a class="btn btn-primary btn-lg" href="#" role="button">Download
					Free Trial »</a> <a class="btn btn-primary btn-lg" href="#"
					role="button">Learn more »</a>
			</p> -->
		</div>
	</div>

	<div style="text-align: center">

		<c:set var="codevalid" value="${valid}" />
		<c:if test="${codevalid == false}">
			<p>
				<img src="resources\\mean-git.png" alt="bad job" width="50">${failmssg}</p>
		</c:if>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>