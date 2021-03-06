<%@ page language="java" import="java.util.*,javax.swing.table.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

Map userInfo = new HashMap();
userInfo = (Map)session.getAttribute("userInfo");
DefaultTableModel  listParking = (DefaultTableModel)session.getAttribute("listParking");
String email = null;
System.out.println("email:"+userInfo.get("email"));
	if(userInfo!=null){
		//session.setAttribute("USER","");
		System.out.println("listview is not null");
		//System.out.println("listview is not null");
		System.out.println("email:"+userInfo.get("email"));
		//System.out.println("pwd:"+userInfo.get("password"));
		email = (String)userInfo.get("email");
	}
	if(listParking!=null && listParking.getRowCount()>0 ){
		System.out.println("listParking_rowcount:"+listParking.getRowCount());
		System.out.println("AVAILABLE_SPACES:"+listParking.getValueAt(0,listParking.findColumn("AVAILABLE_SPACES")));
	}
%>

<!DOCTYPE html>
<html lang="en">
  <head>
       <title>Geo-Sensing</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
<script type="text/javascript" src="js/jquery-3.4.0.js"></script>
<script type="text/javascript" src="http://maps.google.com/maps/api/js?key=AIzaSyD53PH_kXaJD53yK6fck6TfkFahftkOY3g"></script>
<script type="text/javascript" src="gmaps/gmaps.js"></script>
<script type="text/javascript" src="gmaps/gmaps.min.js"></script>
<script type="text/javascript" src="gmaps/gmaps.min.js.map"></script>
<script type="text/javascript" src="js/geoLocation.js"></script>   
<link href="css/bootstrap.min.css" rel="stylesheet">
    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
        
        
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
        height: 400px;
          width: 100%;
      }
      
      }
    </style>
      
    <!-- Custom styles for this template -->
    <link href="css/index.css" rel="stylesheet">
      
  </head>
  <body>
    <div class="sticky-top d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
        <img class="mb-2 mr-4" src="png/location.png" alt="" width="34" height="34"> 
  <h4 class="my-0 mr-md-auto font-weight-normal">Geo-Sensing</h4>
  <nav class="my-2 my-md-0 mr-md-3">
    <a class="p-2 text-dark" href="#">How It Works</a>
    <a class="p-2 text-dark" href="#">Support</a>
      </nav>
</div>

<div class="pricing-header px-3 py-3 mx-auto text-center">
  <h5 class="alert alert-secondary">
      <a href="booking.html">Start your Booking</a></h5> 
</div>
    <div id="button">
    	<button type="button" class="btn btn-outline-success"  id="testMap">testMap</button>
    </div>   
   <div id="button">
    	<button type="button" class="btn btn-outline-success"  id="startRouting">startRouting</button>
    </div>   
 <script type="text/javascript">
    var map;
    
    function initMap() {
        var directionsDisplay = new google.maps.DirectionsRenderer;
        var directionsService = new google.maps.DirectionsService;


        calculateAndDisplayRoute(directionsService, directionsDisplay);
        ///document.getElementById('mode').addEventListener('change', function() {
        //calculateAndDisplayRoute(directionsService, directionsDisplay);
        //});
      }
      
    //function calculateAndDisplayRoute(directionsService, directionsDisplay,position) {
    
    function calculateAndDisplayRoute(position) {
    		var directionsDisplay = new google.maps.DirectionsRenderer;
	        var directionsService = new google.maps.DirectionsService;
    		alert("define map");
	    	var googlemap = new google.maps.Map(document.getElementById('map'), {
	          zoom: 14,
	         center: {lat: -12.368438971967333, lng: 130.86813254695653}
	        });
	
	        directionsDisplay.setMap(googlemap);
	        
			alert("calculate");
			//var selectedMode = document.getElementById('mode').value;
			var selectedMode = "DRIVING";
	        //var startpointA = new google.maps.LatLng(-12.368438971967333,130.86813254695653);
	        var startpointA = new google.maps.LatLng(position.coords.latitude,position.coords.longitude);

		    var endpointB = new google.maps.LatLng(-12.371799145462651,130.86761444807055);
		    
	        directionsService.route({
	          //origin: {lat: -12.368438971967333, lng: 130.86813254695653},  // pointA.
	          //destination: {lat: -12.371799145462651, lng: 130.86761444807055},  // pointB
	          origin: startpointA,
	          destination: endpointB,
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
	        //user location
	        if (navigator.geolocation) {
            	getUserLocation(googlemap);
            	
            	setInterval(function () {
                	getUserLocation(googlemap);
           		 }, 5000);
        }
	        //getUserLocation(googlemap);
      }
      
   
      function getUserLocation(googlemap) {
            if (navigator.geolocation) {
                alert("navigator.geolocation");
                navigator.geolocation.getCurrentPosition(function (position) {
                    var point = new google.maps.LatLng(position.coords.latitude,
                        position.coords.longitude);
				   alert("position.coords.longitude"+position.coords.longitude);
				   
                   if (typeof getUserLocation.user_marker == 'undefined') {
                   //if (true) {
                        getUserLocation.user_marker = new google.maps.Marker({
                            position:point,
                            map: googlemap
                            //icon:'person.png'
                        });
                        alert("add  maker");
                        getUserLocation.user_marker_window = new google.maps.InfoWindow({
                            content:'You'
                        });

                        //google.maps.event.addListener(getUserLocation.user_marker, 'click', function () {
                        //    getUserLocation.user_marker_window.open(getUserLocation.user_marker);
                        //});
                    }
                    //getUserLocation.user_marker.setPosition(point);
                });
            }
        }
		/* 
        if (navigator.geolocation) {
            getUserLocation(gmap);
            setInterval(function () {
                getUserLocation(gmap);
            }, 5000);
        }
      */
    $(document).ready(function(){
       map = new GMaps({
        el: '#map',
        lat: -12.368438971967333, 
        lng: 130.86813254695653,
        zoom: 15
          });
   
   
   
   	
   
   	  /* */
   	  $("#startRouting").click(function(){
	   	    alert("dcwcw");
		//get location,start routing   
			GMaps.geolocate({
			    success: function(position){	      
		       	 	calculateAndDisplayRoute(position);   
		    	}
	 	 	});   
	  });
  
   	

	
		
		
    	$("#tableDetails").hide();  
		$("#showdetails" ).hide();  
         
    
        
    $( "#testMap" ).click(function(event) {
 		map = new GMaps({
        el: '#map',
        lat: -12.371799145462651, 
        lng: 130.86761444807055,
        zoom: 20
          });   
          
        $("#tableDetails").show();  
  		$("#showdetails" ).show();  
        $("#tableInfo").hide();  
        alert($( "#parkingArea" ).val());
        $.get('<%=path%>/bookingAction!listSlots.action',{parking_id:$("#parkingArea").val()},function(responseJson) {
			if(responseJson!=null){
				$("#tableDetails").find("tr:gt(0)").remove();
				var table1 = $("#tableDetails");
				//alert("alert response:="+responseJson);
				/* **/
				var rowTr = 1;
				$.each(responseJson, function(key,value) { 
				var rowNew = $("<tr >"+
				"<td id=\"parking_id"+rowTr+"\">"+
				"<td id=\"slot_id"+rowTr+"\">"+
				"<td id=\"status"+rowTr+"\">"+
				"<td id=\"price"+rowTr+"\">"+
				"<td id=\"booking_time"+rowTr+"\">"+
				"<td id=\"booking_button"+rowTr+"\">"+
					"<button type=\"button\" class=\"btn btn-outline-success\"  id=\"booking_slot\">Book Now</button>"+
				"</tr>");
					rowNew.children().eq(0).text(value['parking_id']); 
					rowNew.children().eq(1).text(value['slot_id']); 
					rowNew.children().eq(2).text(value['status']); 
					rowNew.children().eq(3).text(value['price'] + "$ per Hr"); 
					rowNew.children().eq(4).text(value['charging_from']+" AM - "+ value['charging_to'] +" PM "); 
					//rowNew.children().eq(5).text(value['charging_to']); 
					rowNew.appendTo(table1);
					rowTr = rowTr + 1;
					//disable booking button according to status - 'Unavailable'
					if(value['status']=='Unavailable'){
						rowNew.children().eq(5).children().toggleClass("btn-outline-danger");
						rowNew.children().eq(5).children().attr("disabled",true);
					}
				});

				var table=document.querySelector("#tableDetails");
				console.dirxml(table);
			}
		});
          

//drawPolygon        
var pathB = [
new google.maps.LatLng(-12.371684359129558, 130.86758096682388),
new google.maps.LatLng(-12.371722348017714, 130.86762790548164),
new google.maps.LatLng(-12.371748547247712, 130.86759974228698),
new google.maps.LatLng(-12.37171448824821, 130.86755548583824)];
   
var pathA = [
new google.maps.LatLng(-12.371782606242784, 130.8674964772399),
new google.maps.LatLng(-12.371823215038793, 130.86753536927063),
new google.maps.LatLng(-12.371798325777478, 130.86756085025627),
new google.maps.LatLng(-12.371756407016196, 130.86751927601654)];
        
polygon1 = map.drawPolygon({
        paths: pathA,
        strokeColor: '#000000',
        strokeOpacity: 1,
        strokeWeight: 3,
        fillColor: '#ff0000',
        fillOpacity: 1
      });    

polygon2 = map.drawPolygon({
        paths: pathB,
        strokeColor: '#000000',
        strokeOpacity: 1,
        strokeWeight: 3,
        fillColor: '#008000',
        fillOpacity: 1
      }); 

   
         GMaps.geolocate({
		    success: function(position){     	 	
				map.addMarker({
			        lat: position.coords.latitude,
			        lng: position.coords.longitude,
			        fences: [polygon1],
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
});


	

var path = [
            [-12.36865307501286, 130.86828340572174],
            [-12.368841711626416, 130.8690344242459],
            [-12.369208504651823, 130.87055791896637],
            [-12.369606736496342, 130.87226380389984],
            [-12.369795372421361, 130.8729933647519], 
            [-12.369847771265247, 130.87321867030914],
            [-12.371283495498567, 130.87287534755524],
            [-12.373180316145135, 130.87239254993256],
            [-12.373526143839115, 130.87241400760468],
            [-12.373756695380699, 130.87224234622772],
            [-12.373924369101285, 130.87213505786713], 
            [-12.374154920291316, 130.87230671924408],
            [-12.374333073344218, 130.87246765178497],
            [-12.374930409164095, 130.87282170337494],
            [-12.37560110038612, 130.87335814517792],
            [-12.376474529842493, 130.8721404265517],
            [-12.375216986594396, 130.87029506674946], 
            [-12.375091231936503, 130.8685355376357],
            [-12.374755885886032, 130.8670764159316],
            [-12.374210947635593, 130.86604644766987],
            [-12.373456415873155, 130.86527397147358],
            [-12.372492288782292, 130.86467315665425]
     
          ];
      polygon3 = map.drawPolygon({
        paths: path,
        strokeColor: '#FF0000',
        strokeOpacity: 1,
        strokeWeight: 3,
        fillColor: '#BBD8E9',
        fillOpacity: 0.6
      });
      GMaps.geolocate({
		    success: function(position){
	       	 	
				map.addMarker({
			        lat: position.coords.latitude,
			        lng: position.coords.longitude,
			        fences: [polygon3],
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
   


		
		
      
    });
     
  </script>     
      
      
<div class="container" style="overflow:visible">
  <div id="map"></div>
    <div class="container" style="overflow:visible">
  <div id="map"></div>
<table class="table" id="tableInfo">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Parking Area</th>
      <th scope="col">Available Spaces</th>
      <th scope="col">Price</th>
      <th scope="col">Booking Times</th>
    </tr>
  </thead>
  <tbody>
  <%	
    if(listParking!=null){
     	for (int i=0 ; i<listParking.getRowCount();i++ ){
		System.out.println("listParking_rowcount:"+listParking.getRowCount());
		System.out.println("AVAILABLE_SPACES:"+listParking.getValueAt(i,listParking.findColumn("AVAILABLE_SPACES")));
   %>
    <tr>
      <th scope="row"><button value="A" id="parkingArea" type="button" class="btn btn-outline-success" >Purple A</button></th>
      <td><%=listParking.getValueAt(i,listParking.findColumn("AVAILABLE_SPACES"))%></td>
      <td>$<%=listParking.getValueAt(i,listParking.findColumn("PRICES"))%>-2hr</td>
      <td><%=listParking.getValueAt(i,listParking.findColumn("CHARGING_FROM"))%>-
      <%=listParking.getValueAt(i,listParking.findColumn("CHARGING_TO"))%></td>
    </tr>
  <% 
    	} 
    }	
  %>
    <!-- Pink B is removed!
    <tr>
      <th scope="row"><button value="A" id="parkingArea" type="button" class="btn btn-outline-success" >Pink B</button></th>
      <td>12</td>
      <td>$3-2hr</td>
      <td>8am-4pm</td>
    </tr>
    -->
  </tbody>
</table>
<table class="table table-bordered" id="tableDetails">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Parking Area</th>
        <th scope="col" >Parking Slot</th>
        <th scope="col">Status</th>
     <th scope="col">Price</th>
      <th scope="col">Booking Times</th>
        <th scope="col">Book Slot</th>
    </tr>
  </thead>
  <tbody>
  <!-- remove demo html -->
  <!-- 
    <tr>
      <th scope="row"><h3 type="" class="" >Purple A</h3></th>
      <td>Slot 1</td>
      <td id="a_slot1">Available</td>
        <td>$3-2hr</td>
         <td>8am-4pm</td>
         <td><button type="button" class="btn btn-outline-success" id="slot1">Book Now</button></td>
    </tr>
    <tr>
      <th scope="row"></th>
      <td>Slot 2</td>
      <td id="a_slot2">Unavailable</td>
        <td>$3-2hr</td>
         <td>8am-4pm</td>
         <td><button type="button" class="btn btn-outline-danger"  id="slot2">Book Now</button></td>
    </tr>
      <tr>
      <th scope="row"></th>
      <td >Slot 3</td>
      <td id="a_slot3">Unavailable</td>
        <td>$3-2hr</td>
         <td>8am-4pm</td>
         <td><button type="button" class="btn btn-outline-danger" id="slot3">Book Now</button></td>
    </tr>
      <tr>
      <th scope="row"></th>
      <td >Slot 4</td>
      <td id="a_slot4">Available</td>
        <td>$3-2hr</td>
         <td>8am-4pm</td>
         <td><button type="button" class="btn btn-outline-success" id="slot4">Book Now</button></td>
    </tr>
    -->
  </tbody>
    
</table>
    <button type="button" class="btn btn-outline-secondary" id="showdetails">Back</button>

    
    
  <footer class="pt-4 my-md-5 pt-md-5 border-top">
    <div class="row">
      <div class="col-12 col-md">
        <img class="mb-2" src="png/location.png" alt="" width="24" height="24">
        <small class="d-block mb-3 text-muted">&copy; 2019 Geo-Sensing</small>
      </div>

    </div>
  </footer>
      </div> 
</body>
</html>

