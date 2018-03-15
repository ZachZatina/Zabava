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

<title>Create Quest</title>
<style>
#map {
	height: 400px;
	width: 100%;
}
</style>
</head>
<body>
	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="./">ZabavaQuest</a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">About</a></li>
					<li><a href="https://zabavaquest.com/adminlogin">Create</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">
		<div class="jumbotron">
			<h1>Create a Quest</h1>
			<br> <br>
			<h2>Step 2: Enter Quest Details</h2>
			<br>

			<form action="builder" method="post">
				<!-- FIXME: need to pass these values in from enter page, until we can read from the map -->
				<input type="hidden" name="creatorid" value="${creatorID}">
				<input type="hidden" name="lat" value="${lat}"> <input
					type="hidden" name="lon" value="${lng}">
				<div class="form-group">
					<label for="qname">Give your Quest a name:</label> <input
						type="text" class="form-control" id="qname" name="questName"
						required>
				</div>
				<div class="form-group">
					<label for="rad">Enter a radius to define the scope (enter
						in meters):</label> <input type="number" class="form-control" id="rad"
						name="radius">
				</div>
				<div class="form-group">
					<label for="lim">Enter the maximum number of venues you
						would like to add to the Quest:</label> <input type="number"
						class="form-control" id="lim" name="limit">
				</div>
				<input type="submit" class="btn btn-primary btn-md"
					value="Create Quest">

			</form>

		</div>
		
		<div class="well-container">
			<div class="location-well">
				<h3>Selected Location:</h3>
			</div>
		</div>
		<!-- FIXME: read coordinates from the map to send-->
		<div id="map"></div>

	</div>
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