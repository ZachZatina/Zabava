<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Quest: ${questName}</title>
</head>
<body>
<table>
<tr>
<th>Venue Name</th>
<th>Question</th>
<th>Answer</th>
<th>  </th>
</tr>

<c:forEach var="myVar" items="${tasks}">
<tr>
<form action="#" method="POST">
<input type="hidden" name="taskID" value=${myVar.taskID}>
<input type="hidden" name="questID" value=${questID}>
<td>${myVar.locationName}</td>
<td><input type="text" name="taskdesc" placeholder="Question to Answer" required></td>
<td><input type="text" name="taskanswer" placeholder="Answer to the Question" required></td>
<td><input type="submit" value="Submit"></td>
</form>
</tr>
</c:forEach>

</table>

</body>
</html>