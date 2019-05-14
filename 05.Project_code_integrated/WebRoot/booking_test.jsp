<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
   
 <script type="text/javascript">
    var map;
    $(document).ready(function(){
       map = new GMaps({
        el: '#map',
        lat: -12.368438971967333, 
        lng: 130.86813254695653,
        zoom: 15
          });
   
    $("#tableDetails").hide();  
	$("#showdetails" ).hide();  
        
        //show original table
        $( "#showdetails" ).click(function() {           
            $("#tableDetails").hide(); 
        	$("#tableInfo").show();  
            $("#showdetails" ).hide();  
        });
        
        
         //once booked change slot to unavailable 
        $( "#slot1" ).click(function() {         
           $('#a_slot1').text("Unavailable");   
            $("#slot1").toggleClass("btn-outline-danger");
        });
       
         $( "#slot2" ).click(function() {           
           $('#a_slot2').text("Unavailable");   
        });
              
         $( "#slot3" ).click(function() {           
           $('#a_slot3').text("Unavailable");   
        });
                
         $( "#slot4" ).click(function() {   
           	 $('#a_slot4').text("Unavailable"); 
             $("#slot4").toggleClass("btn-outline-danger");
        });
        
		//Test Booking button - Ajax Asyn call

        $("#slot_submit1").live("click",function(event) {
        //$("#slot_submit1").click(function() {
        	alert($(this).parent().attr("id"));
        	alert($(this).parent().parent().children().eq(2).attr("id"));
        	$(this).parent().parent().children().eq(2).text("Unavailable"); 
           	 //$('#status1').text("Unavailable"); 
             //$("#slot_submit1").toggleClass("btn-outline-danger");
            $.get('<%=path%>/bookingAction!updateAjax.action',{parking_id:"Donald", slot_id:"Ducktown" },function(responseJson) {
			 	if(responseJson!=null){
				
			 	}
               	$('#a_slot4').text("Unavailable"); 
               	$("#slot4").toggleClass("btn-outline-danger");
        	});
        });      
    
        
    $( "#purple" ).click(function(event) {
 		map = new GMaps({
        el: '#map',
        lat: -12.371799145462651, 
        lng: 130.86761444807055,
        zoom: 20
          });   
          
        $("#tableDetails").show();  
  		$("#showdetails" ).show();  
        $("#tableInfo").hide();  
        //
        $.get('<%=path%>/bookingAction!callAjax.action',function(responseJson) {
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
					"<button type=\"button\" class=\"btn btn-outline-danger\"  id=\"slot_submit"+rowTr+"\">Book Now</button>"+
				"</tr>");
					rowNew.children().eq(0).text(value['parking_id']); 
					rowNew.children().eq(1).text(value['slot_id']); 
					rowNew.children().eq(2).text(value['status']); 
					rowNew.children().eq(3).text(value['price'] + "$ per Hr"); 
					rowNew.children().eq(4).text(value['charging_from']+" AM - "+ value['charging_to'] +" PM "); 
					//rowNew.children().eq(5).text(value['charging_to']); 
					rowNew.appendTo(table1);
					rowTr = rowTr + 1;
				});
				
				
				var table=document.querySelector("#tableDetails");
				console.dirxml(table);
			}
		});
          

        
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
        
polygon = map.drawPolygon({
        paths: pathA,
        strokeColor: '#000000',
        strokeOpacity: 1,
        strokeWeight: 3,
        fillColor: '#ff0000',
        fillOpacity: 1
      });    
       polygon = map.drawPolygon({
        paths: pathB,
        strokeColor: '#000000',
        strokeOpacity: 1,
        strokeWeight: 3,
        fillColor: '#008000',
        fillOpacity: 1
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
      polygon = map.drawPolygon({
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
      
    });
     
  </script>     
      
      
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
    <tr>
      <th scope="row"><button id="purple" type="button" class="btn btn-outline-success" >Purple A</button></th>
      <td>2</td>
      <td>$3-2hr</td>
      <td>8am-4pm</td>
    </tr>
    <tr>
      <th scope="row"><button type="button" class="btn btn-outline-success" >Pink B</button></th>
      <td>12</td>
      <td>$3-2hr</td>
      <td>8am-4pm</td>
    </tr>
   
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

