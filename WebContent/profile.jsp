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
        <li><a href="profilecontroller">Profile</a></li>
        
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
              <h3 class="panel-title"><%String name = request.getParameter( "name" );
					    if ( name == null )
					    {
						%>
					    <p>No parameter name given to this page.</p>
						<%
					    }
					    else
					    {
						%>
						<%
					    }%>
					  
					     <%String surname = request.getParameter( "surname" );
					    if ( surname == null )
					    {
						%>
					    <p>No parameter surname given to this page.</p>
						<%
					    }
					    else
					    {
						%>
					    <p><%= name.toString() %> &nbsp;<%= surname.toString() %></p>
						<%
					    }%></h3> 
            </div>
            <div class="panel-body">
              <div class="row">
                <div class="col-md-3 col-lg-3 " align="center"> <img alt="User Pic" src="http://babyinfoforyou.com/wp-content/uploads/2014/10/avatar-300x300.png" class="img-circle img-responsive"> </div>
                
               
                <div class=" col-md-9 col-lg-9 "> 
                  <table class="table table-user-information">
                    <tbody>
                      <tr>
                        <td>Name:</td>
                        <td>
                        <%
					    if ( name == null )
					    {
						%>
					    <p>No parameter name given to this page.</p>
						<%
					    }
					    else
					    {
						%>
					    <p><%= name.toString() %></p>
						<%
					    }%>
					    </td>
                      </tr>
                      <tr>
                        <td>Surname:</td>
                        <td>
                        <%
					    if ( surname == null )
					    {
						%>
					    <p>No parameter surname given to this page.</p>
						<%
					    }
					    else
					    {
						%>
					    <p><%= surname.toString() %></p>
						<%
					    }%></td>
                      </tr>
                       <tr>
                        <td>User name:</td>
                        <td>
                        <%String username = request.getParameter( "username" );
					    if ( username == null )
					    {
						%>
					    <p>No parameter user name given to this page.</p>
						<%
					    }
					    else
					    {
						%>
					    <p><%= username.toString() %></p>
						<%
					    }%>
                        </td>
                      </tr>
                       <tr>
                        <td>Age</td>
                        <td><%String age = request.getParameter("age");   
						if ( username == null )
					    {
						%>
					    <p>No parameter user name given to this page.</p>
						<%
					    }
					    else
					    {
						%>
					    <p><%= age.toString() %></p>
						<%
					    }%>
					    </td>
                      </tr>
                       <tr>
                        <td>University</td>
                        <td>
						<%String university = request.getParameter("university");   
						if ( university == null )
					    {
						%>
					    <p>No parameter user university given to this page.</p>
						<%
					    }
					    else
					    {
						%>
					    <p><%= university.toString() %></p>
						<%
					    }%>
						</td>
                      </tr>
                      <tr>
                        <td>Email</td>
                        <td>
                        	<%String email = request.getParameter("email");   
						if ( email == null )
					    {
						%>
					    <p>No parameter user email given to this page.</p>
						<%
					    }
					    else
					    {
						%>
					    <p><%= email.toString() %></p>
						<%
					    }%>
					    </td>
                      </tr>    
                      <tr>
                        <td>Interests</td>
                        <td>
                        	<%String interests = request.getParameter("interests");   
						if ( interests == null )
					    {
						%>
					    <p>No parameter user interests given to this page.</p>
						<%
					    }
					    else
					    {
						%>
					    <p><%= interests.toString() %></p>
						<%
					    }%>
					    </td>
                      </tr>                             
                  
                    </tbody>
                  </table>
                  
                  <a href="#" class="btn btn-primary">Send Friendship Request</a>                   
                                
                </div>
              </div>
            </div>
                 <div class="panel-footer">
                        <span class="pull-right">
                            <a href="editprofile.jsp" data-original-title="Edit this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-warning"><i class="glyphicon glyphicon-edit"></i></a>
                        </span>
                    </div>
            
          </div>
        </div>
      </div>
    </div>


</body>
</html>