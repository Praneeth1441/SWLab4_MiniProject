package com.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.student;
import com.model.teacher;

/**
 * Servlet implementation class studentregistration
 */
@WebServlet("/teacherregistration")
public class teacherregistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
    public teacherregistration() 
    {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		String name = req.getParameter("user");
		String password = req.getParameter("pass");
		String mobile = req.getParameter("mobile");
		String email = req.getParameter("email");
		
		int Class = Integer.parseInt(req.getParameter("class"));
		String subject = req.getParameter("subject");
		teacher s = new teacher(name, password, mobile, email, Class, subject);
		try {
			s.AddToDb();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Cookie ck=new Cookie("userid",Integer.toString(s.getId()));
			res.addCookie(ck);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		res.sendRedirect("idinfot.jsp");
	}

}
