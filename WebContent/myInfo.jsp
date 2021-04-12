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
			
			
			
	%>
	<h3 style="text-align:center;">Your details</h3>
	<div>
			<table>
				<tr>
					<td>Name</td><td><%= t.getName() %></td>
				</tr>
				<tr>
					<td>Class</td><td><%= t.getclass_name() %></td>
				</tr>
				<tr>
					<td>Email</td><td><%= t.getemail() %></td>
				</tr>
				<tr>
					<td>ID</td><td><%= t.getId() %></td>
				</tr>
				<tr>
					<td>Mobile</td><td><%= t.getcontact() %></td>
				</tr>
			</table>
	</div>

</body>
</html>