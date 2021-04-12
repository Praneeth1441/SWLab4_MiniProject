package com.controllers;
import com.model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import com.mysql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/studentlogin")
public class studentlogin extends HttpServlet 
{
	@SuppressWarnings("unused")
	private static student getDetails(int id) throws Exception
	{
		student s = new student();
		s.getdetails(id);
		return s;
	}
	private static final long serialVersionUID = 1L;
    
    public studentlogin() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("WELCOME");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		student s = null;
		try {
			s = getDetails(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(s.getemail()!=null)
		{
			String password = request.getParameter("password");
			if(password.equals(s.getPassword()))
			{
				try {
					Cookie ck=new Cookie("userid",Integer.toString(s.getId()));
					response.addCookie(ck);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				response.sendRedirect("afterstudentlogin.jsp");
			}
			else
			{
				response.sendRedirect("intro.jsp");
			}
		}
		else
		{
			response.sendRedirect("intro.jsp");
		}
	}


}
