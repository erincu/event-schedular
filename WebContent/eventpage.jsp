<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Event" %>
    <%@ page import="java.util.*" %>

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
<title>Search</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>


<%if(session.getAttribute("username") == null){
    response.sendRedirect("login.jsp");
}%>
<nav class="navbar navbar-default">
  <div class="container-fluid">
  
    <div class="navbar-header">
     
      <a class="navbar-brand" href="searchevent">Home</a>
    </div>
    
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    
      <ul class="nav navbar-nav">
     
        
      </ul>
      <form class="navbar-form navbar-left" method="post" action="searchcontroller">
        <div class="form-group">
          <input type="text" name="namesearch" class="form-control" placeholder="Search">
        </div>
        <button type="submit" name="action" class="btn btn-default" value="search">Search</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
         <%String username = (String) request.getSession().getAttribute("username");%>
			<p class="navbar-text navbar-left" style="color:#000000">Signed in as <a href="profilecontroller" class="navbar-link"><%=username %></a></p>
	        
	
        <div class="col-lg-10" >
	      
	    	<form class="nav navbar-nav navbar-right" method="link" action="logoutcontroller" >	       
	       	<button class="btn btn-lg btn-primary btn-block"  type="submit" name="action" value="Log out!">Log out!</button>	     
	        </form>
	    </div>
        
      </ul>
    </div>
  </div>
</nav>

<div class="container">
      <div class="row">
      <div class="col-md-5  toppad  pull-right col-md-offset-3 ">
   
       <br>
      </div>
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
   
   
          <div class="panel panel-info">
            <div class="panel-heading">
              <h3 class="panel-title"></h3> 
            </div>
            <div class="panel-body">
              <div class="row">
                <div class="col-md-3 col-lg-3 " align="center"> <img alt="User Pic" src="http://babyinfoforyou.com/wp-content/uploads/2014/10/avatar-300x300.png" class="img-circle img-responsive"> </div>
                
               
                <div class=" col-md-9 col-lg-9 "> 
                  <table class="table table-user-information">
                    <tbody>
                      <tr>
                      <%
                      		String status;
                        	Event event = new Event();
	                        session = request.getSession();
	    	    			event = (Event)session.getAttribute("event");
	    	    			
	    	    			status = (String)session.getAttribute("status");
	    	    			
	    	    			int eid = event.getEid();
	    	    			System.out.println("status");
	    	    			String eventname = event.getEventName();
	    	    			String eventdate = event.getEventDate();
	    	    			String eventplace = event.getEventPlace();
	    	    			String eventcreator = event.getCreator();
	    	    			String capacity = String.valueOf(event.getCapacity());
	    	    			String type = event.getType();
	    	    			
	    	    			
                        %>
                       
                        <td>Event Name:</td>
                        <td><%= eventname%></td>
                        <td>
                        
                       
					    </td>
                      </tr>
                      <tr>
                        <td>Event Date:</td>
                        <td><%= eventdate%></td>
                      </tr>
                       <tr>
                        <td>Event Place:</td>
                        <td> <%= eventplace %></td>
                      </tr>
                       <tr>
                        <td>Event Capacity:</td>
                        <td> <%= capacity %>
					    </td>
                      </tr>
                       <tr>
                        <td>Event Type</td>
                        <td>
						 <%= type %>
						</td>
                      </tr>
                       <tr>
                        <td>Organizer</td>
                        <td>
						 <%= eventcreator %>
						</td>
                      </tr>
                      
                                                 
                  
                    </tbody>
                  </table>
                                 
                                
                </div>
              </div>
            </div>
                 <tr>
                 <%if(status == null){ %>
			        <form method="Post" action="attandanceeventcontroller">
			           
			     				      
						 <input type="hidden" name="eid" value="<%=eid%>" />
						   
					
			  <td>	  <button class="btn btn-lg btn-primary btn-block" type="submit" name="join" value="">Join</button></td>
			     
			</form>
			
			<%}else if(status == "participant"){ %>
			<form method="Post" action="attandanceeventcontroller">
			           
			     				      
						 <input type="hidden" name="eid" value="<%=eid%>" />
						   
					
			  <td>	  <button class="btn btn-lg btn-primary btn-block" type="submit" name="drop" value="">Drop</button></td>
			     
			</form>
			<%}else{ %>
			<form method="Post" action="attandanceeventcontroller">
			           
			     				      
						 <input type="hidden" name="eid" value="<%=eid%>" />
						   
					
			  <td>	  <button class="btn btn-lg btn-primary btn-block" type="submit" name="cancel" value="">Cancel</button></td>
			     
			</form>
			<%} %>
			        </tr>
                    </div>
            
          </div>
        </div>
      </div>
    </div>


</body>
</html>