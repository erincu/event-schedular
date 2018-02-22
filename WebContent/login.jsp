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
<title>Event Schedular</title>
</head>
<body>
<% 
if(session.getAttribute("username") != null){
    response.sendRedirect("searchevent");
}%>

	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	    
	    </div>
	  </div>
	</nav>
	
	<br><br>

	<form method="post" action="logincontroller">
	
		<div class="col-lg-3">
            
        <h2>Log in!</h2>  
	    <br>
        <input type="text" name="username" class="form-control" placeholder="Username" aria-describedby="basic-addon1" value="" />
       	<br>
        <input type="password" name="password" class="form-control" placeholder="Password" aria-describedby="basic-addon1" value="" />
        <br>
       <br>
       <button class="btn btn-lg btn-primary btn-block" type="submit" name="action" value="Login">Log in</button>
       <button class="btn btn-lg btn-primary btn-block" type="reset" name="action" value="Reset">Reset</button>
            <br>        
       <td colspan="2">Yet Not Registered!! <a href="register.jsp">Register Here</a></td>
       
       </div>     
       
       	<%
        if(session.getAttribute("loggedIn") != null){ %>
        <div><tr><td>
   		 Sorry. Wrong user name or password</td></tr>
       
        </div>  
        <%} %>
    </form>



	
	
	
</body>
</html>