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
	  bounds.extend(new google.maps.LatLng(marker.position.lat(), marker.position.lng()));
	  console.log(bounds.isEmpty())
	  map.fitBounds(bounds);       
	  map.panToBounds(bounds);   
	  i += 1;
	</c:forEach>			
	}  
	</script>
	<script async defer
	src="${mScript}">
	</script>
	
	<form action="completequest" method="post">
	<input type="hidden" name="questId" value="${questId}">
		<table>
			<c:forEach var="task" items="${tList}" varStatus="counter">
			<tr>
			<td>${counter.count}. ${task.locationName} ${task.address} ${task.csz} <br>
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