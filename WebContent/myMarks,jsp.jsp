<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.model.*,java.util.HashMap" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Marks Display</title>
<style>
table, td, th {
  border: 1px solid black;
}

table {
	margin-left:auto; 
	margin-right:auto;
	border-collapse: collapse;
	width: 30%;
	background: #f2f2f2;;
}

th, td {
  padding: 15px;
  text-align: left;
}
th {
  background-color: #4CAF50;
  color: white;
}
</style>
</head>
<body>

	<%
			//HttpSession session_type = request.getSession();
		
	int id = 0;
	Cookie ck[]=request.getCookies();  
	for(int i=0;i<ck.length;i++)
	{  
 		if(ck[i].getName().equals("userid"))
 		{
 			id = Integer.parseInt(ck[i].getValue());
 			break;
 		}
	}  
			
			student t = new student();
			
			t.getdetails(id);
			
			
			HashMap<String, Integer> m = t.getHashMap();
	%><h3 style="text-align:center;">Your Marks</h3>
	<div>
			<table>
				<tr>
					<td>MATHS</td><td><%= m.get("maths") %></td>
				</tr>
				<tr>
					<td>PHYSICS</td><td><%= m.get("physics") %></td>
				</tr>
				<tr>
					<td>BIOLOGY</td><td><%= m.get("biology") %></td>
				</tr>
				<tr>
					<td>SOCIAL</td><td><%= m.get("social") %></td>
				</tr>
				<tr>
					<td>ENGLISH</td><td><%= m.get("english") %></td>
				</tr>
			</table>
	</div>

</body>
</html>