<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<title>Admin Create Quest</title>
<style>
       #map {
        height: 400px;
        width: 100%;
       }
    </style>
</head>
<body>

<h1>Create a Quest</h1> <br>
<!-- use map to get, or enter lat and lon -- hardcoded below for now -->

<form action="builder" method="post">
<input type="hidden" name="lat" value="42.335953">
<input type="hidden" name="lon" value="-83.049774">
Quest name: <input type="text" name="questName" required><br>
Radius (enter in meters): <input type="number" name="radius"><br>
Maximum number of venues: <input type="number" name="limit"><br><br>

<input type="submit" value="Create Quest">
</form>
<br>
${address}

<h3>Current location (drag marker to center your quest)</h3>
    <div id="map"></div>
    <script>
      function initMap() {
       
        var set0 = {lat: 42.33645874, lng: -83.04835879}
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
  </body>
</html>


</body>
</html>