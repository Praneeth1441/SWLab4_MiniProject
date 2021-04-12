<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<HTML>
       <HEAD>
       <TITLE>EDIT EMAIL</TITLE>
       </HEAD>
       <BODY BGCOLOR="cyan">
			
            <%
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
               try {

				String connectionURL = "jdbc:mysql://localhost:3306/miniproject";

				Connection connection = null;

				Statement statement = null;

				ResultSet rs = null;

				connection = DriverManager.getConnection(connectionURL, "root", "Andrews30!");

				statement = connection.createStatement();
				
				String email=request.getParameter("mail");
				
				statement.executeQuery("UPDATE student SET email_id = '"+email+"' WHERE id = '"+id+"'");
				
				rs = statement.executeQuery("select * from student where id = '"+id+"'") ;

            %>
			<H5>After updating email</H5>
                <TABLE BORDER="1">
           <TR>
           <TH>ID</TH>
                 <TH>Name</TH>
                 <TH>Mail</TH>
                 <TH>Mobile number</TH>
          </TR>
           <% while(rs.next()){ %>
           <TR>
           		<TD><%=rs.getString(1)%></TD>
               <TD><%=rs.getString(2)%></TD>
				<TD><%=rs.getString(5)%></TD>
				<TD><%=rs.getString(4)%></TD>
          </TR>
           <% } %>
		   <%
			// close all the connections.
			rs.close();
			statement.close();
			connection.close();
			} catch (Exception ex) {
			
			}
			%>
               </TABLE>
         </BODY>
</HTML>
