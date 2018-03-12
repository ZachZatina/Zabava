<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Quest: ${questName}</title>
</head>
<body>

	QuestID is: ${questID}
	<form action="showquest" method="POST">
		<input type="hidden" name="questID" value="${questID}">
		<table>

			<tr>
				<th>Venue Name</th>
				<th>Question</th>
				<th>Answer</th>
				<th> </th>
				<th>Delete</th>
			</tr>

			<c:forEach var="myVar" items="${tasks}" varStatus="status">
				<tr>
					<input type="hidden" name="taskID" value="${myVar.taskID}"> <!-- added double quotes -->
					<!--  <input type="hidden" path="${myVar.questID}"> -->
					<td>${myVar.locationName}</td>
					<td><input type="text" name="taskdesc"
						placeholder="Question to Answer"></td>
					<td><input type="text" name="taskanswer"
						placeholder="Answer to the Question"></td>
					<td><img src="${myVar.taskPhotoURL}"></td>
					<td><a href="delete?taskandquest=${myVar.taskID},${questID}">Delete</a>
				</tr>
			</c:forEach>

		</table>
		<h3>Click submit to store your questions and answers</h3>
		<input type="submit" name="Submit">

	</form>

