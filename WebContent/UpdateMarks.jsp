<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="login-box" style=" width: 320px;
	    height: 420px;
	    background: rgba(0, 0, 0, 0.3);
	    color: #fff;
	    top: 60%;
	    left: 50%;
	    position: absolute;
	    transform: translate(-50%,-50%);
	    box-sizing: border-box;
	    padding: 70px 30px;">
	        <h1 style="margin: 0;
	    padding: 0 0 20px;
	    text-align: center;
	    font-size: 22px;">Update Marks:</h1>
	            <form action="Update_marks">
	            <p style="font-weight: bold;  margin: 0;
	    padding: 0;">Student id</p>
	            <input type="text" name="student_id" placeholder="Enter student id" style="border: none;
	    border-bottom: 1px solid #fff;
	    background: transparent;
	    outline: none;
	    height: 40px;
	    color: #fff;
	    font-size: 16px;
		 width: 100%;
	    margin-bottom: 20px;">
	            <p style="font-weight: bold; margin: 0;
	    padding: 0;">Marks</p>
	            <input type="text" name="marks" placeholder="Enter student marks" style="border: none;
	    border-bottom: 1px solid #fff;
	    background: transparent;
	    outline: none;
	    height: 40px;
	    color: #fff;
	    font-size: 16px;
		 width: 100%;
	    margin-bottom: 20px;">
	            <input type="submit" name="submit" value="Update" style="border: none;
	    outline: none;
	    height: 40px;
	    background: #1c8adb;
	    color: #fff;
	    font-size: 18px;
	    border-radius: 20px;
		 width: 100%;
	    margin-bottom: 20px;">   
	            </form>
	        
	        
	    </div>
</body>
</html>