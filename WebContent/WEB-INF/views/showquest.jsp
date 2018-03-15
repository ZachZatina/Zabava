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

<title>Your Quest</title>
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
				<li><a href="https://zabavaquest.com/adminlogin">Create</a></li>
				<li><a href="about">About</a></li>
			</ul>
		</div>
	</div>
	</nav>
	
	<table class="table-bordered">

		<tr>
			<th>Venue Name</th>
			<th>Address</th>
			<th>Question</th>
			<th>Answer</th>

		</tr>
		<c:forEach var="myVar" items="${tasks}" varStatus="status">
			<tr>
				<input type="hidden" name="taskID" value=${myVar.taskID}>
				<input type="hidden" name="questID" value=${questID}>
				<td>${myVar.locationName}</td>
				<td>${myVar.address}</td>
				<td>${myVar.taskDesc}</td>
				<td>${myVar.taskAnswer}</td>
			</tr>
		</c:forEach>
		</form>

	</table>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>