<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!-- Does the order of above matter? -->
<html>
<head>

<title>Zabava Quest Home</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="resources\styles.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<h1>Bootstrap test</h1>
		<p>This is some text.</p>
		<!-- <img src="resources\FFcharacter.JPG" alt="it's an image"> -->
	</div>
	<br>
	<div style="text-align: center">
		<h2>Welcome to ZabavaQuest!</h2>
		<br> <br>
		<h3>
			<form action="quest" method="post">
				Enter your QuestCode here: <input type="text" name="code"> <input
					type="submit" Value="Submit">
			</form>
			<br>
		</h3>
		<c:set var="codevalid" value="${valid}" />
		<c:if test="${codevalid == false}">
			<p>${failmssg}</p>
		</c:if>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>