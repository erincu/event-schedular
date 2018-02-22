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


<title>Create Event</title>
</head>
<body>
<%
//allow access only if session exists
if(session.getAttribute("username") == null){
    response.sendRedirect("login.jsp");
}
%>


	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	    <%String username = (String) request.getSession().getAttribute("username");%>
			<p class="navbar-text navbar-left" style="color:#FFFFFF">Signed in as <a href="#" class="navbar-link"><%=username %></a></p>
	        
	    </div>
	    <div class="col-lg-10" >
	      
	    	<form class="nav navbar-nav navbar-right" method="link" action="logoutcontroller" >	       
	       	<button class="btn btn-lg btn-primary btn-block"  type="submit" name="action" value="Log out!">Log out!</button>	     
	        </form>
	    </div>
	  </div>
	</nav>
	
	<br><br>	
	


	<form method="post" action="eventcontroller">       
            <div class="col-lg-3">
            
            <h2>Create Event</h2>  
         
            <input type="text" name="eventName" class="form-control" placeholder="Event Name" aria-describedby="basic-addon1" value="">
            <br>
            <input type="text" name="eventDate" class="form-control" placeholder="Event Date" aria-describedby="basic-addon1" value="" />
            <br>
            <input type="text" name="eventPlace" class="form-control" placeholder="Event Place" aria-describedby="basic-addon1" value="" />
            <br>
            <input type="text" name="capacity" class="form-control" placeholder="Capacity" aria-describedby="basic-addon1" value="" />
            <br>
            <div class="input-group">
      		
      		<p>Select Tag(s) for the Event:</p>
	        <!--  <input type="radio" name="music" id="music" value="music" /><label for="music">Music</label><br />
	        <input type="radio" name="sports" id="sports" value="sports"  /><label for="sports">Sports</label><br />
	        <input type="radio" name="dance" id="dance" value="dance" /><label for="dance">Dance</label><br />
	        <input type="radio" name="art" id="art" value="art" /><label for="art">Art</label><br />
	        <input type="radio" name="party" id="party" value="party" /><label for="party">Party</label><br />
	        <input type="radio" name="travel" id="travel" value="travel" /><label for="travel">Travel</label><br />-->
	         <input type="checkbox" name="music" value="music"/><label for="music">Music</label><br/>
	 		<input type="checkbox" name="dance" id="dance" value="dance" /><label for="dance">Dance</label><br />
	        <input type="checkbox" name="art" id="art" value="art" /><label for="art">Art</label><br />
	        <input type="checkbox" name="party" id="party" value="party" /><label for="party">Party</label><br />
	        <input type="checkbox" name="travel" id="travel" value="travel" /><label for="travel">Travel</label><br />
	 		</div>
	 		 
            
            <button class="btn btn-lg btn-primary btn-block" type="submit" name="action" value="CreateEvent">Create Event</button>
           	<button class="btn btn-lg btn-primary btn-block" type="reset" name="action" value="Reset">Reset</button>        	
           
            </div>
</form>             


</body>
</html>