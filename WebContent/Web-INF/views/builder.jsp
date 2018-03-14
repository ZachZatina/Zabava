<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

<title>Edit Quest: ${questName}</title>
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
				<a class="navbar-brand" href="index">ZabavaQuest</a>
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
		QuestName is: ${questName}
		<form action="showquest" method="POST">
			<input type="hidden" name="questID" value="${questID}">
			<table>

				<tr>
					<th>Venue Name</th>
					<th>Question</th>
					<th>Answer</th>
					<th></th>
					<th>Delete</th>
				</tr>

				<c:forEach var="myVar" items="${tasks}" varStatus="status">
					<tr>
						<input type="hidden" name="taskID" value="${myVar.taskID}">
						<!-- added double quotes -->
						<%--  <input type="hidden" path="${myVar.questID}"> --%>
						<td>${myVar.locationName}</td>
						<td><input id=${status.count}a type="text" name="taskdesc"
							placeholder="Question to Answer"></td>
						<td><input id=${status.count}b type="text" name="taskanswer"
							placeholder="Answer to the Question"></td>
						<td><img src="${myVar.taskPhotoURL}"></td>
						<td><a class="btn btn-primary btn-lg"
							href="delete?taskandquest=${myVar.taskID},${questID}"
							role="button">Delete</a></td>
						<form>
							<td><input checked="checked" type="radio" name="formType"
								value="question"
								onclick="document.getElementById('${status.count}a').style.visibility = 'visible';document.getElementById('${status.count}b').placeholder = 'Answer to the Question ';document.getElementById('${status.count}a').value = '';">Question
								Answer</td>
							<br>
							<td><input type="radio" name="formType" value="image"
								onclick="document.getElementById('${status.count}a').style.visibility = 'hidden';document.getElementById('${status.count}b').placeholder = 'Link to your Photo ';document.getElementById('${status.count}a').value = 'Link to your Photo ';">Image</td>
							<br>
						</form>
					</tr>
				</c:forEach>

			</table>
			<h3>Click submit to store your questions and answers</h3>
			<input type="submit" name="Submit">
		</form>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>