<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="resources\\styles.css" rel="stylesheet" />
<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'>

<title>Completed Quest Answers</title>
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
		<div class="jumbotron quest">
			<h1 style="text-align: center">Congratulations on completing
				this quest!</h1>
			<h2>
				<table align="center">
					<!-- <tr> -->
					<tr align="center">
						<th>
							<div class="completelist" align="center">Correct Answers</div>
						<th>
							<div class="completelist" align="center">Your Answers</div>
						</th>
					</tr>
					<!-- <tr> -->
					<tr align="center">
						<td>
							<div class="completelist" align="center">
								<table>
									<c:forEach var="adminAnswers" items="${aAnswers}">
										<tr>
											<td>${adminAnswers}</td>
										</tr>
									</c:forEach>
								</table>
							</div>
						</td>
						<td>
							<div class="completelist" align="center">
								<table>
									<c:forEach var="inputAnswers" items="${uAnswers}">
										<tr>
											<td>${inputAnswers}</td>
										</tr>
									</c:forEach>
								</table>
							</div>
						</td>
					</tr>

				</table>
			</h2>
			<br> <br>

			<div align="center">
				<form action="./" method="post">
					<input type="submit" class="btn btn-primary"
						value="Try Another Quest" />
				</form>
			</div>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>