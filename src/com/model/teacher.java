package com.model;

import java.sql.*;
import java.util.HashMap;

public class teacher {
	int id;
	String name;
	String password;
	String contactno;
	String email_id;
	String subject;
	int class_name;
	HashMap<Integer , Integer> marks = new HashMap<Integer , Integer>();
	
	public teacher(String name, String password, String contactno, String email_id, int class_name,String subject)
	{
		this.name = name;
		this.password = password;
		this.contactno = contactno;
		this.email_id = email_id;
		this.class_name = class_name;
		this.subject = subject;
	}
	
	public teacher() {
		// TODO Auto-generated constructor stub
	}

	public int getId() throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/miniproject";
		String uname = "root";
		String pass = "Andrews30!";
		String query = "SELECT id FROM teacher where name ='" + this.name +"'";
		
		//Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		String value = rs.getString("id");
		
		return Integer.parseInt(value);
		
	}
	
	public void getdetails(int id) throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/miniproject";
		String uname = "root";
		String pass = "Andrews30!";
		String query = "SELECT * FROM teacher where id =" + id;
		
		//Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		this.name = rs.getString("name");;
		this.password = rs.getString("password");;
		this.contactno = (rs.getString("mobile_no"));
		this.email_id = rs.getString("email_id");
		this.class_name = Integer.parseInt(rs.getString("class"));
		this.subject = rs.getString("subject");
	}
	
	public void getMarks() throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/miniproject";
		String uname = "root";
		String pass = "Andrews30!";
		String query = "SELECT id,"+this.subject+" FROM student where class =" + this.class_name;
		
		//Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next())
		{
			this.marks.put(Integer.parseInt(rs.getString("id")), Integer.parseInt(rs.getString(subject)));
		}
	}
	
	public void AddToDb() throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/miniproject";
		String uname = "root";
		String pass = "Andrews30!";
		String query = "INSERT INTO teacher (name, password, mobile_no, email_id, class, subject) values(?,?,?,?,?,?)";
		
		
		//Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, this.name);
		st.setString(2, this.password);
		st.setString(3, this.contactno);
		st.setString(4, this.email_id);
		st.setInt(5, this.class_name);
		st.setString(6, this.subject);
		st.executeUpdate();
		this.id = getId();
		
	}
	
	public void setMarks(int student_id,int marks) throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/miniproject";
		String uname = "root";
		String pass = "Andrews30!";
		String query = "UPDATE student SET " + this.subject+" = "+ marks +" WHERE id =" + student_id;
		
		//Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);
		Statement st = con.createStatement();
		st.executeUpdate(query);
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getEmail()
	{
		return this.email_id;
	}
	
	public String getMobileNo()
	{
		return this.contactno;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	public String getSubject()
	{
		return this.subject;
	}
	
	public int getClassName()
	{
		return this.class_name;
	}
	
	public HashMap<Integer, Integer> getHashmap()
	{
		return this.marks;
	}
	
	
	
	public String setName(String name)
	{
		return this.name = name;
	}
	
	public String setEmail(String email_id)
	{
		return this.email_id = email_id;
	}
	
	public String setMobileNo(String contactno)
	{
		return this.contactno = contactno;
	}
	public String setPassword(String password)
	{
		return this.password = password;
	}
	
	public String setSubject(String subject)
	{
		return this.subject = subject;
	}
	
	public int setClassName(int class_name)
	{
		return this.class_name = class_name;
	}
	
	public HashMap<Integer, Integer> setHashmap(HashMap<Integer, Integer> marks)
	{
		return this.marks = marks;
	}
	
	public static void main(String[] args) throws Exception 
	{
		String name = "sarma";
		String password = "sarma";
		String mobile = "sarma";
		String email = "sarma";
		int Class = 4;
		String subject = "maths";
		teacher t = new teacher(name, password, mobile, email, Class, subject);
		
	    System.out.println(t.getEmail());
	    
	    t.AddToDb();
	   
	}
	
}
