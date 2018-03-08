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


<%--  This is a Spring Form, not an HTML Form --%>
<form:form action="showquest" method="POST" commandName="tasks">
<table>

<tr>
<th>Venue Name</th>
<th>Question</th>
<th>Answer</th>
<th>  </th>
</tr>

<c:forEach var="myVar" items="${tasks}" varStatus="status">
<tr>
<%-- <input type="hidden" name="taskID" value=${myVar.taskID}> --%>
<%-- <input type="hidden" name="questID" value=${questID}> --%>
<td>${myVar.locationName}</td>
<td><form:input path="MyVar[${status.index}].taskDesc" type="text" name="taskdesc" placeholder="Question to Answer" /></td>
<td><form:input path="MyVar[${status.index}].taskAnswer" type="text" name="taskanswer" placeholder="Answer to the Question" /></td>
</tr>
</c:forEach>

</table>
<input type="submit" name="Submit">

</form:form>


</body>
</html>