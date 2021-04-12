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
			
			teacher t = new teacher();
			
			t.getdetails(id);
			
			t.getMarks();
			
			HashMap<Integer , Integer> marks = t.getHashmap();
			
	%>
	<div>
			<div class = "container" style= "text-align:center;"><h3><%= t.getSubject() %> marks of Class <%= t.getClassName() %></h3></div>
			<table>
				<tr>
	                 <th>Student id</th>
	                 <th>Marks</th>
	          	</tr>
	          	<%
	          		for(Integer i : marks.keySet()){
				%>
	          	<tr>
	              	<td><%=i%></td>
	   				<td><%=marks.get(i) %></td>
	          	</tr>
	          	<% } %>
			</table>
	</div>

</body>
</html>