<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">

<!-- Optional theme -->
<link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->

<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="bootstrap/jquery-1.11.3.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>
</head>
<body>

<% 
if(session.getAttribute("username") != null){
    response.sendRedirect("home.jsp");
}%>

	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	    </div>
	  </div>
	</nav>
	
	<br><br>
	

	<form method="post" action="registercontroller">         
    
            <div class="col-lg-3">
            
            <h2>Sign Up Here!</h2>  
                   
            <input type="text" name="name" class="form-control" placeholder="Name" aria-describedby="basic-addon1" value="">
            <br>
            <input type="text" name="surname" class="form-control" placeholder="Surname" aria-describedby="basic-addon1" value="" />
            <br>
            <input type="text" name="username" class="form-control" placeholder="Username" aria-describedby="basic-addon1" value="" />
            <br>
            <input type="text" name="age" class="form-control" placeholder="Age" aria-describedby="basic-addon1" value="" />
            <br>
            <input type="text" name="university" class="form-control" placeholder="University" aria-describedby="basic-addon1" value="" />
            <br>
            <input type="text" name="email" class="form-control" placeholder="Email" aria-describedby="basic-addon1" value="" />
            <br>
            <input type="password" name="password" class="form-control" placeholder="Password" aria-describedby="basic-addon1" value="" />
            <br>
            <button class="btn btn-lg btn-primary btn-block" type="submit" name="action" value="Signup">Sign up</button>
           	<button class="btn btn-lg btn-primary btn-block" type="reset" name="action" value="Reset">Reset</button>
                        
            </div>
            
                    
                    
        
           
        </form>

</body>
</html>