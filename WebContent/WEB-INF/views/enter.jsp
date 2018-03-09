<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Admin Create Quest</title>
</head>
<body>

	<h1>Admin page: Create a Quest</h1>
	<br><br>
	<h2>Step 1: Enter an address to serve as the starting point for your Quest.</h2> 
	<form action="admin" method="post">
		<br>
		Street: <input type="text" name="streetaddress" required><br>
		City: <input type="text" name="city" required><br>
		State: <input type="text" name="state" required><br>
		<br>
		<input type="submit" value="Submit">
	</form>
	<c:set var="addressvalid" value="${valid}" />
	<c:if test="${addressvalid == false }">
		<p>${failmssg}</p>
	</c:if>

</body>
</html>