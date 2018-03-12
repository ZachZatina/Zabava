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



<form action="showquest" method="POST">
<table>

<tr>
<th>Venue Name</th>
<th>Question</th>
<th>Answer</th>
<th>  </th>
</tr>

<c:forEach var="myVar" items="${tasks}" varStatus="status">
<tr>
<input type="hidden" name="taskID" value=${myVar.taskID}>
<%--  <input type="hidden" path="${myVar.questID}"> --%>
<td>${myVar.locationName}</td>
<td><input type="text" name="taskdesc" placeholder="Question to Answer"></td>
<td><input type="text" name="taskanswer" placeholder="Answer to the Question"></td>
<td><img src="${myVar.taskPhotoURL}"></a>
</tr>
</c:forEach>

</table>
<input type="submit" name="Submit">

</form>


</body>
</html>