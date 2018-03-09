<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html> <!-- Does the order of above matter? -->
<html>
<head>

<title>Zabava Quest Home</title>
</head>
<body>
	<br>
	<div style="text-align:center">
		<h2>
			Welcome to ZabavaQuest!<br><br>
		</h2>
		<h3>
		<form action="quest" method="post">
		Enter your QuestCode here:
		<input type="text" name="code">
		<input type="submit" Value="Submit">
		</form>
		<br>
		</h3>
		<c:set var="codevalid" value="${valid}"/>
		<c:if test="${codevalid == false}">
			<p>${failmssg}
			</p>
		</c:if>
	</div>
</body>
</html>