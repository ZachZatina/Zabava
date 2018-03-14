<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="resources\\styles.css" rel="stylesheet" />
<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'>

<title>Admin Create Quest</title>
<style>
#map {
	height: 400px;
	width: 100%;
}
</style>
</head>
<body>
	<h1>Admin page: Create a Quest</h1>
	<br>
	<br>
	<h2>Step 2: Enter Quest details</h2>
	<br>

	<form action="builder" method="post">
		<!-- FIXME: need to pass these values in from enter page, until we can read from the map -->
		<input type="hidden" name="creatorid" value="${creatorID}">
		<input type="hidden" name="lat" value="${lat}"> <input
			type="hidden" name="lon" value="${lng}"> Give your Quest a
		name: <input type="text" name="questName" required><br>
		Enter a radius to define the scope (enter in meters): <input
			type="number" name="radius"><br> Enter the maximum
		number of venues you would like to add to the Quest: <input
			type="number" name="limit"><br> <br> <input
			type="submit" value="Create Quest">
	</form>
	<br>

	<h3>Selected location</h3>
	<!-- FIXME: read coordinates from the map to send-->
	<div id="map"></div>
	<script>
      function initMap() {
       
        var set0 = {lat: ${lat}, lng: ${lng}}
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 16,
          center: set0
        });
        var marker = new google.maps.Marker({
          position: set0,
          map: map,
          draggable:true,
          title:"Drag me!"
        });
      }
    </script>
	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=${mapkey}&callback=initMap">
    </script>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>