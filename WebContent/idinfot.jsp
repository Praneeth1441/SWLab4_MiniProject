<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.model.*" %>
    <%int id = 0;
Cookie ck[]=request.getCookies();  
for(int i=0;i<ck.length;i++)
{  
		if(ck[i].getName().equals("userid"))
		{
			id = Integer.parseInt(ck[i].getValue());
			break;
		}
}  
	
		 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>Your id number is <%= id %></h1>
  <a href = "intro.jsp"><button>Go to Login Page</button></a>
</body>
</html>