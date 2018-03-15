<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="resources\\styles.css" rel="stylesheet" />
<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'>
<title>Your Quests</title>
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

	<br>

	<center>
		<form action="enter" method="post">
			<input type="hidden" name="creatorid" value="${creatorID}"> <input
				type="submit" value="Make New Quest">
		</form>
	</center>

	<center>
		<div class="container">
			<div class="jumbotron">
				<h2>My previous quest codes:</h2>
				<br>
				<div class="questBox" align="center">
					<table>
						<tr>
							<th>Quest Name</th>
							<th>Quest Code</th>
						</tr>

						<c:forEach var="myVar" items="${quests}">
							<tr>
								<td>${myVar.questName}</td>
								<td><center>${myVar.questCode}</center></td>
							</tr>
						</c:forEach>

					</table>
	</center>
	</div>
	</div>
	</div>
	<center>
		<img src="./resources/Powered-by-Foursquare-black-300.png">
	</center>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>