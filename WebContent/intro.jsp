<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%

Cookie ck = new Cookie("userid", "");
ck.setMaxAge(0);
response.addCookie(ck);
Cookie ck1 = new Cookie("adminid", "");
ck1.setMaxAge(0);
response.addCookie(ck1);
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>ABC SCHOOL</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudfare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
h1 {
  text-shadow: 3px 3px gray;
}
.contenta{
	background-image: url("bp.jpg");
	min-height: 600px;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  position: relative;
}


</style>
</head>
<body>

<div class="container p-3 my-3 border">
  <h1 class="abc" style="font-size: 55px;"><center>ABC MODEL SCHOOL</center></h1>

</div>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Abcmodschool.org</a>
    </div>
    <ul class="nav navbar-nav ">
      <li class="active"><a href="#"class="nav-link home">Home</a></li></ul>
      <ul class="nav navbar-nav navbar-right">
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Log-in <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#" class="nav-link al">Admin</a></li>
          <li><a href="#" class="nav-link tl">Teacher</a></li>
          <li><a href="#" class="nav-link sl">Student</a></li>
        </ul>
      </li>
     
     <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Registration <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#" class="nav-link tr">Teacher</a></li>
          <li><a href="#" class="nav-link sr">Student</a></li>
        </ul>
      </li>
    </ul>
  </div>
</nav>
<div id="content" class="contenta">
	<br><br><br><br><br><br><br><br><p class="text-center" style="font-size:35px; font-style:italic;"><font color="red"></p>
</div>
<script>
	$(document).ready(function(){
		$('.sl').click(function(){
			$('#content').load('sl.html');
		});
	});
	$(document).ready(function(){
		$('.tl').click(function(){
			$('#content').load('tl.html');
		});
	});

	$(document).ready(function(){
		$('.al').click(function(){
			$('#content').load('al.html');
		});
	});
	$(document).ready(function(){
		$('.sr').click(function(){
			$('#content').load('sr.html');
		});
	});
	$(document).ready(function(){
		$('.tr').click(function(){
			$('#content').load('tr.html');
		});
	});
	$(document).ready(function(){
		$('.home').click(function(){
			$('#content').load('home.html');
		});
	});
	
</script>


</body>
</html>
