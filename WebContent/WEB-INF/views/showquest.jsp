<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Quest</title>
</head>
<body>

	<table>
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


</body>
</html>