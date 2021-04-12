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
import com.model.teacher;

/**
 * Servlet implementation class deleteteacher
 */
@WebServlet("/deleteteacher")
public class deleteteacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteteacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = -1;
		id = Integer.parseInt(request.getParameter("id"));
		teacher s = new teacher();
		
		if(id!=-1)
		{
			try {
				s.getdetails(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int year = s.getClassName();
		String subject = s.getSubject();
		String url = "jdbc:mysql://localhost:3306/miniproject";
		String uname = "root";
		String pass = "Andrews30!";
		String query = "DELETE FROM teacher where id = '"+id+"'";
		
		
		try {
			Connection con = DriverManager.getConnection(url, uname, pass);
			Statement statement;
			statement = con.createStatement();
			statement.executeUpdate(query);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("displayTeachers.jsp");
	}

	

}
