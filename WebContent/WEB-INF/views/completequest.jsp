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

	<h1 style="text-align: center">Congratulations on completing this
		quest!</h1>
	<h2>
		<table align="center">
			<tr>
			<tr align="center">
				<th>Correct Answers</th>
				<th>Your Answers</th>
			</tr>
			<tr>
			<tr align="center">
				<td>
					<table>
						<c:forEach var="adminAnswers" items="${aAnswers}">
							<tr>
								<td>${adminAnswers}</td>
							</tr>
						</c:forEach>
					</table>
				</td>
				<td>
					<table>
						<c:forEach var="inputAnswers" items="${uAnswers}">
							<tr>
								<td>${inputAnswers}</td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>

		</table>
	</h2>
	<br>
	<br>

	<div align="center">
		<form action="http://localhost:8080/Zabava/">
			<input type="submit" value="Try Another Quest" />
		</form>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>