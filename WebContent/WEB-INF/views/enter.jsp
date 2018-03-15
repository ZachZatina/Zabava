<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="resources\\styles.css" rel="stylesheet" />
<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'>

<title>Create Quest</title>
</head>
<body>
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
					<li><a href="#">About</a></li>
					<li><a href="https://zabavaquest.com/adminlogin">Create</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">
		<div class="jumbotron">
			<h1>Create a Quest</h1>
			<br> <br>
			<h2>Step 1: Enter an address to serve as the starting point for
				your Quest.</h2>
				
			<form action="admin" method="post">
				<br>
				
				<div class="input-group">
					<input id="street" type="text" class="form-control" name="streetaddress"
						placeholder="Street address" required> 
				</div>
				<div class="input-group">
					<input id="city" type="text" class="form-control" name="city"
						placeholder="City" required> 
				</div>
				<div class="input-group">
					<input id="state" type="text" class="form-control" name="state"
						placeholder="State" required> 
				</div>
				
				<input type="hidden" name="creatorid" value="${creatorID}">
				<br>
				
				<input type="submit" class="btn btn-primary btn-md" value="Submit">
			</form>
			<c:set var="addressvalid" value="${valid}" />
			<c:if test="${addressvalid == false }">
				<p>${failmssg}</p>
			</c:if>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>