/*global $ */

$(document).ready(function(){
    var map;
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
        strokeColor: '#FF0000'
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
map.drawRoute({
origin: [position.coords.latitude, position.coords.longitude],
destination: [-12.371684359129558, 130.86758096682388],
travelMode: 'driving',
strokeColor: '#131540',
strokeOpacity: 0.6,
strokeWeight: 6
});


    }
});

      $( "#purple" ).click(function() {
 map = new GMaps({
        el: '#map',
        lat: -12.371799145462651,
        lng: 130.86761444807055,
        zoom: 20
          });
        $("#tableDetails").show();
        $("#showdetails" ).show();
        $("#tableInfo").hide();

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




    });
