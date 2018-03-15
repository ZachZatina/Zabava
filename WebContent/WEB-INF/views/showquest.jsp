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