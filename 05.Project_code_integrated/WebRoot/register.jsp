<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String alertMsg = null;
alertMsg = (String)session.getAttribute("retStr");
if(alertMsg!=null){
	%>
	<script type="text/javascript">
		alert("<%=alertMsg%>");
	</script>
	<%
}
%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <title>Register Page</title>

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
    .col-md-8 {
      
        margin: auto;
        padding: 10px;
        border-radius: 3px;
     }
   
    </style>
    <!-- Custom styles for this template -->
    <link href="css/form-validation.css" rel="stylesheet">
  </head>
  <body class="bg-light">
    <div class="sticky-top d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
   <a href="index.jsp"> <img class="mb-2 mr-4" src="png/location.png" alt="" width="54" height="54"> </a>
  <h4 class="my-0 mr-md-auto font-weight-normal">Geo-Sensing</h4>
  <nav class="my-2 my-md-0 mr-md-3">
  <a class="btn btn-outline-secondary" href="login.jsp">Sign in</a>
      </nav>
</div>
    <div class="container">
  <div class="py-5 text-center">
    <img class="d-block mx-auto mb-4" src="png/location.png" alt="" width="122" height="122">
    <h2>Register Page</h2>
    <p class="lead">Please enter your details below. All of your information will be secured</p>
  </div>

    <div class="col-md-8 order-md-1">
    
     <!-- xxxxxxx need comment  -->
      <form name="registeruser" method="POST" action="<%=path%>/registerAction!registerUser.action" class="needs-validation" novalidate>
          <h4 class="mb-3">Your Details</h4>
        <div class="row">
          <div class="col-md-6 mb-3">
           
            <input name="firstname" type="text" class="form-control" id="firstName" placeholder="First Name" value="" required>
            <div class="invalid-feedback">
              Valid first name is required.
            </div>
          </div>
          <div class="col-md-6 mb-3">
           
            <input name="lastname" type="text" class="form-control" id="lastName" placeholder="Last Name" value="" required>
            <div class="invalid-feedback">
              Valid last name is required.
            </div>
          </div>
        
          <div class="col-md-6 mb-3">
          
          <input name="email" type="email" class="form-control" id="email" placeholder="Email Address" required>
          <div class="invalid-feedback">
            Please enter a valid email address.
          </div>
        </div>
        <div class="col-md-6 mb-3">
        <!-- 
          <div class="">
            <button type="button" class="btn btn-success">Light</button>
            <div class="invalid-feedback" style="width: 100%;">
              Your Password is required.
            </div>
          </div>
          -->   
        </div>
            <div class="col-md-6 mb-3">
        
          <div class="input-group">
            
            <input name="password2" type="password" class="form-control" id="password2" placeholder="Re-type Password" required>
            <div class="invalid-feedback" style="width: 100%;">
              Your Password is required.
            </div>
          </div>
            
        </div>
        <div class="col-md-6 mb-3">
        
          <div class="input-group">
            <input name="password1" type="password" class="form-control" id="password1" placeholder="Password" required>
            <div class="invalid-feedback" style="width: 100%;">
              Your Password is required.
            </div>
          </div>
            
        </div>
          </div>
        <hr class="mb-4">

        <h4 class="mb-3">Payment Details</h4>

        <div class="row">
          <div class="col-md-6 mb-3">
            <label for="cc-name">Name on card</label>
            <input name="cc_name" type="text" class="form-control" id="cc-name" placeholder="" required>
            <small class="text-muted">Full name as displayed on card</small>
            <div class="invalid-feedback">
              Name on card is required
            </div>
          </div>
          <div class="col-md-6 mb-3">
            <label for="cc-number">Credit card number</label>
            <input name="cc_number" type="text" class="form-control" id="cc-number" maxlength="16" placeholder="" required>
            <div class="invalid-feedback">
              Credit card number is required
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-3 mb-3">
            <label for="cc-cvv">CVV</label>
            <input name="cc_cvv" type="text" class="form-control" id="cc-cvv" maxlength="3" placeholder="" required>
            <div class="invalid-feedback">
              Security code required
            </div>
          </div>
        </div>
        <hr class="mb-4">
        <button class="btn btn-primary btn-block" type="submit">Register</button>
      </form>
    </div>
  </div>

  <footer class="my-5 pt-5 text-muted text-center text-small">
    <p class="mb-1">&copy; 2017-2019 Company Name</p>
  </footer>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
      <script>window.jQuery || document.write('<script src="/docs/4.3/assets/js/vendor/jquery-slim.min.js"><\/script>')</script><script src="/docs/4.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o" crossorigin="anonymous"></script>
        <script src="js/form-validation.js"></script></body>
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
		document.registeruser.submit();
}
</script>

<% session.removeAttribute("retStr"); %>


