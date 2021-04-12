<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<% String id = "";
Cookie ck[]=request.getCookies();  
for(int i=0;i<ck.length;i++)
{  
		if(ck[i].getName().equals("adminid"))
		{
			id = (String)(ck[i].getValue());
			break;
		}
}  

  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADMINISTRATOR</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudfare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#myPage"><%=id%></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="displayStudents.jsp">STUDENTS</a></li>
        <li><a href="displayTeachers.jsp">TEACHERS</a></li>
        <li><a href="intro.jsp">LOGOUT</a></li>
      </ul>
    </div>
  </div>
</nav><br><br><br><br>

<div id = "content" class = "contenta">
</div>
		
		<h2 style="text-align: center">Register a Teacher</h2>
		<div class="container" style="width: 500px;text-align: center">
			<form method = "GET" action="teacherregistration" onsubmit="return validation()" class="bg-light">
				
				<div class="form-group">
					<label for="user" class="font-weight-bold"> Name: </label>
					<input type="text" name="user" class="form-control" id="user" placeholder="Enter Teacher's name">
					<span id="username" class="text-danger font-weight-bold" > </span>
				</div>

				<div class="form-group">
					<label class="font-weight-bold"> Password: </label>
					<input type="text" name="pass" class="form-control" id="pass" placeholder="Enter password">
					<span id="passwords" class="text-danger font-weight-bold"> </span>
				</div>

				<div class="form-group">
					<label class="font-weight-bold"> Confirm Password: </label>
					<input type="text" name="conpass" class="form-control" id="conpass" placeholder="Re-type password">
					<span id="confrmpass" class="text-danger font-weight-bold"> </span>
				</div>

				<div class="form-group">
					<label class="font-weight-bold"> Mobile Number: </label>
					<input type="text" name="mobile" class="form-control" id="mobileNumber" placeholder="Enter Teacher's mobile-no">
					<span id="mobileno" class="text-danger font-weight-bold"> </span>
				</div>

				<div class="form-group">
					<label class="font-weight-bold"> Email: </label>
					<input type="text" name="email" class="form-control" id="emails" placeholder="Enter Teacher's email-id">
					<span id="emailids" class="text-danger font-weight-bold"> </span>
				</div>
				
				<div class="form-group"> 
					<label class="font-weight-bold"> Class: </label>
					<input type="number" name="class" class="form-control" id="class" placeholder="Enter Teacher's class">
					<span id="classid" class="text-danger font-weight-bold"> </span>
				</div>
				<div class="form-group"> 
					<label class="font-weight-bold"> Subject: </label>
					<input type="number" name="subject" class="form-control" id="class" placeholder="Enter Teacher's subject">
					<span id="classid" class="text-danger font-weight-bold"> </span>
				</div>

				<input type="submit" name="submit" value="submit" class="btn btn-success" 	autocomplete="off">


			</form><br><br>


		</div>
		
</body>
</html>