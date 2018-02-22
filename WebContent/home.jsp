<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.*" %>
<%@ page import="model.Event" %>
<%@ page import="java.util.ArrayList" %>
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

<%
//allow access only if session exists
if(session.getAttribute("username") == null){
    response.sendRedirect("login.jsp");
}
%>

<nav class="navbar navbar-default">
  <div class="container-fluid">
  
    <div class="navbar-header">
     
      <a class="navbar-brand" href="searchevent">Home</a>
    </div>
    
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    
      <ul class="nav navbar-nav">
     
        
      </ul>
      <form class="navbar-form navbar-left" method="post" action="http://localhost:8080/Event_Schedular/searchcontroller">
        <div class="form-group">
          <input type="text" name="namesearch" class="form-control" placeholder="Search">
        </div>
        <button type="submit" name="action" class="btn btn-default" value="search">Search</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
      <div class="navbar-header">
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

<br>
        
      <div class="container">
      <div class="row">
      <div class="col-md-5  toppad  pull-right col-md-offset-3 ">
   
       <br>
      </div>
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
   
   
          <div class="panel panel-info">
            <div class="panel-heading">
            
            </div>
            <div class="panel-body">
              <div class="row">
                
                <div class=" col-md-9 col-lg-9 "> 
                  <table class="table table-user-information">               
                    <tbody>
                    <tr>
			            <td>Event Name</td>
			            <td>Event Place</td>
			            <td>Organizer</td>			            
			        
			        </tr>
                      <%
        			ArrayList<Event> events = new ArrayList<Event>();
	            
	            	session = request.getSession();
	    			events = (ArrayList<Event>)session.getAttribute("eventList");
	    			if(events !=null){
	                for(Event event: events){
	                
	                String name = event.getEventName();
	                String date = event.getEventDate();
	                String place = event.getEventPlace();
	                String organiser = event.getCreator();
	                int eid = event.getEid();
	                String type = event.getType();
	             
	                int capacity = event.getCapacity();
	                System.out.println(name +" "+ place);
			        %>
			         
			       
			        <tr>
			        <form method="Post" action="eventdisplaycontroller">
			            <td><%=name.toString() %></td>
			            <td><%=place.toString() %></td>
			            <td><%=organiser.toString() %></td>
			            <td><%=type.toString() %></td>
			         
			            
						 <input type="hidden" name="eid" value="<%=eid%>" />
					
			  <td>	  <button class="btn btn-lg btn-primary btn-block" type="submit" name="action" value="">Display</button></td>
		
				</form>
			        </tr>
			        <%
			          
			        
			        
			                }
			    		}
	    			
			        %>
			  		
			  		<tr>
			  		<form method="post" action="event.jsp">
			  			 <td> <button class="btn btn-lg btn-primary btn-block" type="submit" name="action" value="">Create Event</button>
		</td>
			  		</form></tr>
			  		<%
       				 if(session.getAttribute("message") != null){
					String mes =(String)session.getAttribute("message");	%>
        			<div><tr><td>
   		 				<%=mes %></td></tr>
       
       				 </div>  
        			<%} %>
                  </tbody>
                  </table>
                                     
                                
                </div>
              </div>
            </div>
            
            
          </div>
        </div>
      </div>
    </div>


</body>
</html>