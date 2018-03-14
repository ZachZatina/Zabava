<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="resources\\styles.css" rel="stylesheet" />
<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'>


<title>Admin: Create Quest</title>
</head>
<body>
	<div class="container">
		<h1>Admin page: Create a Quest</h1>
		<br>
		<br>
		<h2>Step 1: Enter an address to serve as the starting point for
			your Quest.</h2>
		<form action="admin" method="post">
			<br> Street: <input type="text" name="streetaddress" required><br>
			City: <input type="text" name="city" required><br>
			State: <input type="text" name="state" required><br> <br>
			<input type="hidden" name="creatorid" value="${creatorID}">
			<input type="submit" value="Submit">
		</form>
		<c:set var="addressvalid" value="${valid}" />
		<c:if test="${addressvalid == false }">
			<p>${failmssg}</p>
		</c:if>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>