package com.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.student;

/**
 * Servlet implementation class studentchangemobile
 */
@WebServlet("/studentchangeemail")
public class studentchangeemail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentchangeemail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		String newmobile = request.getParameter("id");		
				student t = new student();
				
				try {
					t.getdetails(id);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String url = "jdbc:mysql://localhost:3306/miniproject";
				String uname = "root";
				String pass = "Andrews30!";
				String query = "UPDATE student SET email_id = '"+ newmobile +"' WHERE id ='"+Integer.toString(id)+"'";
				
				//Class.forName("com.mysql.jdbc.Driver");
				Connection con;
				try {
					con = DriverManager.getConnection(url, uname, pass);

					Statement st = con.createStatement();
					st.executeUpdate(query);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				response.sendRedirect("afterstudentlogin.jsp");
	}

}
