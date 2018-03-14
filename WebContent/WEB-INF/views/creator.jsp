<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		
		<table>
			<tr>
			<th>Quest ID</th>
				<th>Quest Name</th>
				<th>Quest Code</th>
				<th>Delete</th>
			</tr>

			<c:forEach var="myVar" items="${quests}">
				<tr>
					<td>${myVar.questId}</td>
					<td>${myVar.questName}</td>
					<td>${myVar.questCode}</td>
					<td></td>
				</tr>
			</c:forEach>

		</table>


<form action="enter" method="post">
<input type="hidden" name="creatorid" value="${creatorID}">
<input type="submit" name="Make New Quest">
</form>
</body>
</html>