<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><link rel="stylesheet" href="bootstrap/css/bootstrap.css">

<!-- Optional theme -->
<link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->

<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="bootstrap/jquery-1.11.3.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
     
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">SearchAccordingly<span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
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
  <form method="post" action="editprofilecontroller">
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
                <div class="col-md-3 col-lg-3 " align="center"> <img alt="User Pic" src="http://babyinfoforyou.com/wp-content/uploads/2014/10/avatar-300x300.png" class="img-circle img-responsive"> </div>
                
               
                <div class=" col-md-9 col-lg-9 "> 
                  <table class="table table-user-information">
                    <tbody>
                      <tr>
                        <td>Name:</td>
                        <td> <input type="text" name="name" class="form-control" placeholder="" aria-describedby="basic-addon1" value="" /></td>
                      </tr>
                      <tr>
                        <td>Surname:</td>
                        <td> <input type="text" name="surname" class="form-control" placeholder="" aria-describedby="basic-addon1" value="" /> </td>
                      </tr>
                        <tr>
                        <td>Username:</td>
                        <td> <input type="text" name="username" class="form-control" placeholder="" aria-describedby="basic-addon1" value="" /> </td>
                      </tr>
                       <tr>
                        <td>Age</td>
                        <td> <input type="text" name="age" class="form-control" placeholder="" aria-describedby="basic-addon1" value="" />  </td>
                      </tr>
                       <tr>
                        <td>University</td>
                        <td> <input type="text" name="university" class="form-control" placeholder="" aria-describedby="basic-addon1" value="" /></td>
                      </tr>
                      <tr>
                        <td>Email</td>
                        <td> <input type="text" name="email" class="form-control" placeholder="" aria-describedby="basic-addon1" value="" />   </td>
                      </tr> 
                        <tr>
                        <td>Password</td>
                        <td> <input type="text" name="password" class="form-control" placeholder="" aria-describedby="basic-addon1" value="" />   </td>
                      </tr> 
                      <tr>
                        <td>Interests</td>
                        <td><input type="checkbox" name="music" value="music"/><label for="music">Music</label><br/>
                        
				 		<input type="checkbox" name="sports" id="sports" value="sports" /><label for="sports">Sports</label><br />
				 		<input type="checkbox" name="dance" id="dance" value="dance" /><label for="dance">Dance</label><br />
				        <input type="checkbox" name="art" id="art" value="art" /><label for="art">Art</label><br />
				        <input type="checkbox" name="party" id="party" value="party" /><label for="party">Party</label><br />
				        <input type="checkbox" name="travel" id="travel" value="travel" /><label for="travel">Travel</label><br /> </td>
                      </tr>   
                    </tbody>
                  </table>
                  
                             
                </div>
              </div>
            </div>
           <div class="panel-footer">
             <span class="pull-right">             
             <button class="btn btn-lg btn-primary btn-block" type="submit" name="action" value="Save">Save</button>
             </span>
           </div>
            
          </div>
        </div>
      </div>
    </div>
  </form>
</body>
</html>