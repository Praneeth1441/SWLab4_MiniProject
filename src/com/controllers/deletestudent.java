package com.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.student;

/**
 * Servlet implementation class deletestudent
 */
@WebServlet("/deletestudent")
public class deletestudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletestudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int id = -1;
		id = Integer.parseInt(request.getParameter("id"));
		student s = new student();
		if(id!=-1)
		{
			try {
				s.getdetails(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String url = "jdbc:mysql://localhost:3306/miniproject";
		String uname = "root";
		String pass = "Andrews30!";
		
		String query = "DELETE FROM student where id = '"+id+"'";
		
		
		try {
			Connection con = DriverManager.getConnection(url, uname, pass);
			Statement statement;
			statement = con.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("displayStudents.jsp");
	}

}
