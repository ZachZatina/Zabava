<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<style>
#map {
	height: 400px;
	width: 100%;
}
</style>

</head>
<body>
	Your QuestCode: ${code}
	<br>
	Your QuestID: ${questId}
	<br>
	<div id="map"></div>
	${mapIn}

	<form action="completequest" method="post">
	<input type="hidden" name="questId" value="${questId}">
		<table>
			<c:forEach var="task" items="${tList}">
			<tr>
			<td>${task.locationName} ${task.address} ${task.csz} <br>
			${task.taskDesc}<br>
			<input type="text" name="input" maxlength="10">
			<br>
			<br>
			</td>
			</tr>
			</c:forEach>
		</table>
		
		<input type="submit" value="Submit">
	</form>
</body>
</html>