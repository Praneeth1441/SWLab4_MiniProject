package com.model;

import java.util.HashMap;
import java.sql.*;

public class student 
{
	int id;
	String name;
	String password;
	String contactno;
	String email_id;
	int class_name;
	public int getclass_name()
	{
		return this.class_name;
	}
	HashMap<String, Integer> marks = new HashMap<String, Integer>();
	
	
	public String getcontact()
	{
		return this.contactno;
	}
	public String getemail()
	{
		return email_id;
	}
	
	public student(String name, String password, String contactno, String email_id, int class_name)
	{
		this.name = name;
		this.password = password;
		this.contactno = contactno;
		this.email_id = email_id;
		this.class_name = class_name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	public int getId() throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/miniproject";
		String uname = "root";
		String pass = "Andrews30!";
		String query = "SELECT id FROM student where name ='" + this.name +"'";
		
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
		String query = "SELECT * FROM student where id =" + id;
		Connection con = DriverManager.getConnection(url, uname, pass);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		this.name = rs.getString("name");;
		this.password = rs.getString("password");;
		this.contactno = (rs.getString("mobile_no"));
		this.email_id = rs.getString("email_id");
		this.class_name = Integer.parseInt(rs.getString("class"));
		marks.put("maths", Integer.parseInt(rs.getString("maths")));
		marks.put("physics", Integer.parseInt(rs.getString("physics")));
		marks.put("biology", Integer.parseInt(rs.getString("biology")));
		marks.put("social", Integer.parseInt(rs.getString("social")));
		marks.put("english", Integer.parseInt(rs.getString("english")));
	}
	
	public HashMap<String, Integer> getHashMap()
	{
		return this.marks;
	}
	
	public student(int id)
	{
		this.id = id;
		try {
			this.getdetails(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public student() {
		// TODO Auto-generated constructor stub
	}

	public void AddToDb() throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/miniproject";
		String uname = "root";
		String pass = "Andrews30!";
		String query = "INSERT INTO student (name, password, mobile_no, email_id, class) values('"+this.name+"','"+this.password+"','"+this.contactno+"','"+this.email_id+"','"+this.class_name+"')";
		
		Connection con = DriverManager.getConnection(url, uname, pass);
		Statement statement = con.createStatement();
		statement.executeUpdate(query);
		this.id = getId();
		return;
		/*PreparedStatement st = con.prepareStatement(query);
		st.setString(1, this.name);
		st.setString(2, this.password);
		st.setString(3, this.contactno);
		st.setString(4, this.email_id);
		st.setInt(5, this.class_name);
		st.executeUpdate();
		this.id = getId();*/
		
	}	

	
	public static void main(String[] args) throws Exception
	{
	    student s = new student();
	    s.email_id = "NOTTHEREBOY";
	    s.getdetails(2);
	    System.out.println(s.getemail());
	}
	
}
