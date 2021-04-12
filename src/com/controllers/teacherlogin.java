package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.student;
import com.model.teacher;

/**
 * Servlet implementation class teacherlogin
 */
@WebServlet("/teacherlogin")
public class teacherlogin extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       

    public teacherlogin() 
    {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int id = Integer.parseInt(request.getParameter("id"));
		teacher s = new teacher();
		try 
		{
			s.getdetails(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(s.getEmail()!=null)
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
				response.sendRedirect("afterteacherlogin.jsp");
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
