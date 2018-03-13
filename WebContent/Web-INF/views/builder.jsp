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
	<table>
	
	<tr>
	<th>Venue Name</th>
	<th>Question</th>
	<th>Answer</th>
	<th>  </th>
	<th>Delete</th>
	</tr>
	
	<c:forEach var="myVar" items="${tasks}" varStatus="status">
	<tr>
	<input type="hidden" name="taskID" value=${myVar.taskID}>
	<%--  <input type="hidden" path="${myVar.questID}"> --%>
	<td>${myVar.taskID} ${myVar.locationName}</td>
	<td><input id=${status.count}a type="text" name="taskdesc" placeholder="Question to Answer"></td>
	<td><input id=${status.count}b type="text" name="taskanswer" placeholder="Answer to the Question"></td>
	<td><img src="${myVar.taskPhotoURL}"></td>
	<td><a href="delete?taskandquest=${myVar.taskID},${questID}">Delete</a>
	<form>
	<td><input checked="checked" type="radio" name="formType" value="question" onclick="document.getElementById('${status.count}a').style.visibility = 'visible';document.getElementById('${status.count}b').placeholder = 'Answer to the Question ';document.getElementById('${status.count}a').value = '';">Question Answer</td><br>
	<td><input type="radio" name="formType" value="image" onclick="document.getElementById('${status.count}a').style.visibility = 'hidden';document.getElementById('${status.count}b').placeholder = 'Link to your Photo ';document.getElementById('${status.count}a').value = 'Link to your Photo ';">Image</td><br>
	</form>
	</tr>
	</c:forEach>
	
	</table>
	<h3>Click submit to store your questions and answers</h3>
	<input type="submit" name="Submit">
	
	</form>


</body>
</html>

