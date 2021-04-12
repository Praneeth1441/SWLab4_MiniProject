package com.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.teacher;


/**
 * Servlet implementation class Update_Marks
 */
@WebServlet("/Update_marks")
public class Update_Marks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update_Marks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int student_id = Integer.parseInt(req.getParameter("student_id"));
		int marks = Integer.parseInt(req.getParameter("marks"));
		
		int id = 0;
    	Cookie ck[]=req.getCookies();  
    	for(int i=0;i<ck.length;i++)
    	{  
     		if(ck[i].getName().equals("userid"))
     		{
     			id = Integer.parseInt(ck[i].getValue());
     			break;
     		}
    	}  
		
		
		
		teacher t = new teacher();
		try {
			t.getdetails(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		try {
			t.setMarks(student_id, marks);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		res.sendRedirect("afterteacherlogin.jsp");
	}


}
