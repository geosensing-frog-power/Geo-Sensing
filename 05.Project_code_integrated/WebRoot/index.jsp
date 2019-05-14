<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
  <head>
       <title>Geo-Sensing </title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
   
<script type="text/javascript" src="js/jquery-3.4.0.js"></script>
<script type="text/javascript" src="http://maps.google.com/maps/api/js?key=AIzaSyD53PH_kXaJD53yK6fck6TfkFahftkOY3g"></script>
<script type="text/javascript" src="gmaps/gmaps.js"></script>
<script type="text/javascript" src="js/geoLocat"></script>   
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
 <a class="btn btn-outline-primary mx-1" href="register.jsp">Register</a>
  <a class="btn btn-outline-secondary" href="login.jsp">Sign in</a>
      </nav>
</div>

      <div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light">
  <div class="col-md-5 p-lg-5 mx-auto my-5">
    <h1 class="display-4 font-weight-normal">CDU Parking</h1>
    <p class="lead font-weight-normal">Say Goodbye to tickets and coins. </p>  <p class="lead font-weight-normal">This locaton based parking system does it all for you. </p> <p class="lead font-weight-normal"> Just park and walk away.</p>
    <a class="btn btn-outline-secondary" href="register.jsp">Register now </a>
  </div>
</div>
      
    <footer class="container py-5p t-4 my-md-5 pt-md-5 border-top">
    <div class="row">
      <div class="col-12 col-md">
        <img class="mb-2" src="png/location.png" alt="" width="24" height="24">
        <small class="d-block mb-3 text-muted">&copy; 2019 Geo-Sensing</small>
      </div>

    </div>
  </footer>
      
      
      
</body>
</html>

