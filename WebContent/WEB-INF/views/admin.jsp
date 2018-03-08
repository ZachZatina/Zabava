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
<h1>Admin page: Create a Quest</h1>
<br><br>
<h2>Step 2: Enter Quest details</h2> <br>

<form action="builder" method="post">
<!-- FIXME: need to pass these values in from enter page, until we can read from the map -->
<input type="hidden" name="lat" value="${lat}"> 
<input type="hidden" name="lon" value="${lng}">
Give your Quest a name: <input type="text" name="questName" required><br>
Enter a radius to define the scope (enter in meters): <input type="number" name="radius"><br>
Enter the maximum number of venues you would like to add to the Quest: <input type="number" name="limit"><br><br>
<input type="submit" value="Create Quest">
</form>
<br>

<h3>Selected location (Coming soon: Drag the marker to re-position your quest)</h3>
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
  </body>
</html>


</body>
</html>