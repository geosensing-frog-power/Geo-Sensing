<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="generator" content="">
    <title>Signin GeoSense Parking</title>

    <!-- Bootstrap core CSS -->
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
   
    </style>
    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">
  </head>
  <body class="bg-light text-center">
  
  <div class="sticky-top d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
      <a href="index.jsp"> <img class="mb-2 mr-4" src="png/location.png" alt="" width="34" height="34"> </a>
  <h4 class="my-0 mr-md-auto font-weight-normal">Geo-Sensing</h4>
  <nav class="my-2 my-md-0 mr-md-3">
 <a class="btn btn-outline-primary mx-1" href="register.jsp">Register</a>
      </nav>
</div>
    <div class="container">
 
    <form class="form-signin" name="loginForm" method="POST" action="<%=path%>/loginAction!searchUser.action">
  <img class="mb-4" src="png/location.png" alt="" width="72" height="72">
  <h1 class="h3 mb-3 font-weight-normal">Please sign in..</h1>
  <label for="inputEmail" class="sr-only">Email address</label>
  <input type="email" name="email" class="form-control" id="inputEmail" placeholder="Email address" required autofocus>
  <label for="inputPassword" class="sr-only">Password</label>
  <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
  <div class="checkbox mb-3">
    <label>
      <input type="checkbox" value="remember-me"> Remember me
    </label>
  </div>
  <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
  <p class="mt-5 mb-3 text-muted">&copy; 2017-2019 GeoSense Parking</p>
  
</form>
</div>

</body>
</html>
