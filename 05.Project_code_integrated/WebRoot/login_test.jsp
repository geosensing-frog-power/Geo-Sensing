<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>Sign in</title>


    <!-- Bootstrap core CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


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
    <link href="form-validation.css" rel="stylesheet">
  </head>
  <body class="bg-light">
    <div class="container">
  <div class="py-5 text-center">
    <img class="d-block mx-auto mb-4" src="/docs/4.3/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
    <h2>Sign in</h2>
    <p class="lead">Please sign in using your Email and Password</p>
  </div>


<form name="insertuser" method="POST" action="<%=path%>/loginAction!insertUser.action">
        <div class="mb-3" >
<!--            <label for="Email">Email</label> -->
          <div class="input-group">
            <div class="input-group-prepend">
              <span class="input-group-text"></span>
            </div>
            <input name="email" type="text" class="form-control" id="email" placeholder="email" required >
             <div class="invalid-feedback" style="width: 100%;">
              Your Email is required.
            </div>
            
          </div>
        </div>

        <div class="mb-3">
<!--         <label for="Email">Password</label> --> 
          <div class="input-group">
            <div class="input-group-prepend">
              <span class="input-group-text"></span>
            </div>
            <input name="password" type="password" class="form-control" id="password" placeholder="Password" required>
            <div class="invalid-feedback" style="width: 100%;">
              Your Password is required.
            </div>
          </div>            
        </div>

        <hr class="mb-4">
        
	<div align="center">
        <botton class="btn btn-info btn-sm" type="submit" onclick="insertuserForm();">Sign in</botton>
      </form>
    </div>
  </div>

  <footer class="my-5 pt-5 text-muted text-center text-small">
    <p class="mb-1">&copy; 2017-2019 Company Name</p>
    <ul class="list-inline">
      <li class="list-inline-item"><a href="#">Privacy</a></li>
      <li class="list-inline-item"><a href="#">Terms</a></li>
      <li class="list-inline-item"><a href="#">Support</a></li>
    </ul>
  </footer>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
      <script>window.jQuery || document.write('<script src="/docs/4.3/assets/js/vendor/jquery-slim.min.js"><\/script>')</script><script src="/docs/4.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o" crossorigin="anonymous"></script>
        <script src="form-validation.js"></script></body>
</html>
<script type="text/javascript">
function isValid(text) {
	return (/^[A-Za-z_][A-Za-z0-9_]*$/.test(text));
}
function isValidId(id) {
	return isValid(document.getElementById(id).value);
}
function validateId(id) {
	if (isValidId(id))
		return true;
	else {
		alert("must be a letter or underscore followed by alphanumeric or underscore characters");
		return false;
	}
}
function insertuserForm(){
	//if (validateId("insert_name"))
		document.insertuser.submit();
}
</script>
