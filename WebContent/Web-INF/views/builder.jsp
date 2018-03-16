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
					<li><a href="https://zabavaquest.com/adminlogin">Create</a></li>
					<li><a href="about">About</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">

		<div class="editing-well">

			<h3>
				You are currently editing QuestName: <span id="code">${questName}</span>
			</h3>

		</div>

		<div class="panel panel-default">
			<div class="panel-body">
				<form action="showquest" method="POST">
					<input type="hidden" name="questID" value="${questID}">
					<table>

						<tr>
							<th></th>
							<th></th>
						</tr>

						<c:forEach var="myVar" items="${tasks}" varStatus="status">

							<tr>
								<input type="hidden" name="taskID" value="${myVar.taskID}">

								<!-- added double quotes -->
								<%--  <input type="hidden" path="${myVar.questID}"> --%>

								<td class="itembuilder" align="center"><img
									class="imagebuilder" src="${myVar.taskPhotoURL}"></td>

								<td>
									<table>
										<tr>
											<td class="itembuilder">
												<h3>${myVar.locationName}</h3>
											</td>

										</tr>

										<tr>
											<form>
												<td class="itembuilder"><input checked="checked"
													type="radio" name="formType" value="question"
													onclick="document.getElementById('${status.count}a').style.visibility = 'visible';document.getElementById('${status.count}b').style.visibility = 'visible';document.getElementById('${status.count}b').placeholder = 'Answer to the Question ';document.getElementById('${status.count}a').value = '';">Question
													& Answer <input type="radio" name="formType" value="image"
													onclick="document.getElementById('${status.count}a').style.visibility = 'hidden';document.getElementById('${status.count}b').style.visibility = 'hidden';document.getElementById('${status.count}a').value = 'Take a photo of this landmark, upload it to your favorite image sharing site, and paste link here: ';document.getElementById('${status.count}b').value = '';">Request
													a Photo</td>

											</form>

										</tr>
										<tr>

											<td class="itembuilder">
												<div class="input-group">
													<input id=${status.count}a type="text" class="form-control"
														name="taskdesc" placeholder="Question for participant">
												</div>
											</td>
										</tr>
										<tr>
											<td class="itembuilder">
												<div class="input-group">
													<input id=${status.count}b type="text" class="form-control"
														name="taskanswer" placeholder="Desired answer">
												</div>
											</td>
										</tr>
										<tr>
											<td class="itembuilder"><a
												class="btn btn-primary btn-md"
												href="delete?taskandquest=${myVar.taskID},${questID},${questName},${questcode}"
												role="button">Delete this item</a></td>
										</tr>
										</tr>
										</tr>

									</table>
								</td>
							</tr>
							</div>
							</div>
						</c:forEach>

					</table>

					<div class="well well-sm">
						<h3>Click to store your questions and answers</h3>
						<input type="submit" class="btn btn-primary btn-md" value="Submit">
					</div>

				</form>
				<center>
					<img src="./resources/Powered-by-Foursquare-black-300.png">
				</center>

			</div>
			<script
				src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
			<script
				src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>