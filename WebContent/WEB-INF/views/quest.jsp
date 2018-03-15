<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>ZabavaQuest</title>
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
					<li><a href="https://zabavaquest.com/adminlogin">Create</a></li>
					<li><a href="about">About</a></li>
				</ul>
			</div>
			<h4 class="qc">Questcode: ${code}</h4>
		</div>
	</nav>

	<%-- 	<div class="container">
		<div class="well well-sm">
			<h3>
				QuestCode: <span id="code">${code}</span>
			</h3>
		</div> --%>


	<!--  	<div class="container">
		
	</div> -->
	<br>
	<div id="map"></div>

	<!-- added jumbotron quest -->
	<div class="container">
		<div class="jumbotron quest">
			<!-- end -->


			<script>
	function initMap() {
		bounds  = new google.maps.LatLngBounds();
		var i = 1;
		var map = new google.maps.Map(document.getElementById('map'), {
			zoom: 16,
			center: ${mapIn}
		});
		
	<c:forEach var="loc" items="${tList}">
	

	    var marker = new google.maps.Marker({
        	position: {lat: ${loc.lat}, lng: ${loc.lon}},
        	map: map,
        	label: i.toString()
      });
		var infowindow = new google.maps.InfoWindow({});
		
		google.maps.event.addListener(marker, 'mouseover', (function (marker) {
			return function () {
				infowindow.setContent('<p style="text-align:center"><strong>'+"${loc.locationName}"+'</strong><br>'+"${loc.address}"+'</p>');
				infowindow.open(map, marker);
			}
		})(marker));

	  bounds.extend(new google.maps.LatLng(marker.position.lat(), marker.position.lng()));
	  console.log(bounds.isEmpty())
	  map.fitBounds(bounds);       
	  map.panToBounds(bounds);   
	  i += 1;
	</c:forEach>			
	}  
	</script>
			<script async defer src="${mScript}">
	</script>
			<div class="questBox" align="center">
				<form action="completequest" method="post">
					<input type="hidden" name="questId" value="${questId}">
					<table class="table-hover table-bordered">
						<c:forEach var="task" items="${tList}" varStatus="counter">
							<tr>
								<td>${counter.count}.${task.locationName}<br>
									${task.taskDesc}<br> <input type="text" name="input"
									maxlength="50"> <br> <br>
								</td>
							</tr>
						</c:forEach>
					</table>

					<input class="btn btn-primary" type="submit" value="Submit">
				</form>
			</div>
		</div>
		<div align="center">
		<img src="./resources/Powered-by-Foursquare-black-300.png" align="center">
		</div>

	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>