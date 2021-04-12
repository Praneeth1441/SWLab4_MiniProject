<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.model.*,java.util.HashMap" %>
<!DOCTYPE html>
<html>
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
					background-image: url("bg.jpg");
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
		    <ul class="nav navbar-nav">
		      <li class="active"><a href="#" class="nav-link dm">Display marks</a></li>
		      <li class="active"><a href="#" class="nav-link um">Update marks</a></li>
		     
		    </ul>
		    <ul class="nav navbar-nav navbar-right">
		      <li><a href="intro.jsp" ><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
		    </ul>
		  </div>
		</nav>
		<div id="content" class="contenta">
			<br><br><br><br><br><br><br><br><p class="text-center" style="font-size:35px; font-style:italic;"><font color="red">Study for knowledge, not for marks</p>
		</div>

		<script>
			$(document).ready(function(){
				$('.um').click(function(){
					$('#content').load('UpdateMarks.jsp');
				});
			});
		
			$(document).ready(function(){
				$('.dm').click(function(){
					$('#content').load('displayMarks.jsp');
				});
			});
		
			
		</script>
		
	</body>
</html>