<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <title>Travel Modes in Directions</title>
    <style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
        height: 100%;
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
      #floating-panel {
        position: absolute;
        top: 10px;
        left: 25%;
        z-index: 5;
        background-color: #fff;
        padding: 5px;
        border: 1px solid #999;
        text-align: center;
        font-family: 'Roboto','sans-serif';
        line-height: 30px;
        padding-left: 10px;
      }
    </style>
  </head>
  <body>
    <div id="floating-panel">
    <b>Mode of Travel: </b>
    <select id="mode">
      <option value="DRIVING">Driving</option>
      <option value="WALKING">Walking</option>
      <option value="BICYCLING">Bicycling</option>
      <option value="TRANSIT">Transit</option>
    </select>
    
    <div id="button">
    	<button type="button" class="btn btn-outline-success"  id="testMap">testMap</button>
    </div>
    </div>
    <div id="map"></div>

     <script type="text/javascript">
     /*
     $(document).ready(function(){
        var map = new GMaps({
	        el: '#map',
	        lat: -12.368438971967333, 
	        lng: 130.86813254695653,
	        zoom: 15
        });  
        GMaps.geolocate({
		    success: function(position){
				map.addMarker({
			        lat: position.coords.latitude,
			        lng: position.coords.longitude,
			        fences: [polygon],
			        draggable: true,
			        inside:function(m, f){
			          alert('inside the fence');
			        },
			        outside: function(m, f){
			          alert('Outside the fence');
			        }
				}); 
		    }
		});  
     })*/
     
      function initMap() {
        var directionsDisplay = new google.maps.DirectionsRenderer;
        var directionsService = new google.maps.DirectionsService;
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 14,
         center: {lat: -12.368438971967333, lng: 130.86813254695653}
        });

        directionsDisplay.setMap(map);

        calculateAndDisplayRoute(directionsService, directionsDisplay);
        ///document.getElementById('mode').addEventListener('change', function() {
        //calculateAndDisplayRoute(directionsService, directionsDisplay);
        //});
      }
      

	  
      function calculateAndDisplayRoute(directionsService, directionsDisplay) {
			alert("calculate");
		//var selectedMode = document.getElementById('mode').value;
		var selectedMode = "DRIVING";
        var pointA = new google.maps.LatLng(-12.368438971967333,130.86813254695653);
	    var pointB = new google.maps.LatLng(-12.371799145462651,130.86761444807055);
        directionsService.route({
          //origin: {lat: -12.368438971967333, lng: 130.86813254695653},  // pointA.
          //destination: {lat: -12.371799145462651, lng: 130.86761444807055},  // pointB
          origin: pointA,
          destination:pointB,
          // Note that Javascript allows us to access the constant
          // using square brackets and a string value as its
          // "property."
          travelMode: google.maps.TravelMode[selectedMode]
        }, function(response, status) {
          if (status == 'OK') {
            directionsDisplay.setDirections(response);
          } else {
            window.alert('Directions request failed due to ' + status);
          }
        });
      }
      
      document.getElementById('testMap').onclick = function(){
      	alert("dcwcw");
      	//initMap();
      	var directionsDisplay = new google.maps.DirectionsRenderer;
        var directionsService = new google.maps.DirectionsService;
        calculateAndDisplayRoute(directionsService, directionsDisplay);
      };
    </script>
    <!-- 
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD53PH_kXaJD53yK6fck6TfkFahftkOY3g&callback=initMap">
    </script>
     -->
         <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD53PH_kXaJD53yK6fck6TfkFahftkOY3g">
    </script>
  </body>
</html>
