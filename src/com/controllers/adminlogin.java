package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.student;

/**
 * Servlet implementation class adminlogin
 */
@WebServlet("/adminlogin")
public class adminlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public adminlogin() {
        super();
        
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		PrintWriter out = res.getWriter();
		String username = req.getParameter("id");
		String password = req.getParameter("password");
		String url = "jdbc:mysql://localhost:3306/miniproject";
		String uname = "root";
		String pass = "Andrews30!";
		String query = "SELECT * FROM admin where username ='" + username +"'";
		String toCheck = "";
		Connection con;
		try {
			con = DriverManager.getConnection(url, uname, pass);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			toCheck = rs.getString(2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if((!toCheck.equals(""))||toCheck.equals(password))
		{
			Cookie ck = new Cookie("adminid", username);
			ck.setMaxAge(90000);
			res.addCookie(ck);
			res.sendRedirect("afteradminlogin.jsp");
		}
		else
		{
			res.sendRedirect("intro.jsp");
		}
	}

}
