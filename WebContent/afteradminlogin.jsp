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
<div class="container p-3 my-3 border">
  <h1 class="abc" style="font-size: 55px;"><center>ABC MODEL SCHOOL</center></h1>

</div>

<nav class="navbar navbar-inverse">
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
		
</body>
</html>