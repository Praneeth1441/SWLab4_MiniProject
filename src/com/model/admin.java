package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class admin {
	
	String name;
	String password;
	
	public void getdetails(String name) throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/miniproject";
		String uname = "root";
		String pass = "Andrews30!";
		String query = "SELECT password FROM admin where name = '" + name +"'";
		
		//Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		this.name = name;
		this.password = rs.getString("password");
	}
	
	public void deleteStudent(int id) throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/miniproject";
		String uname = "root";
		String pass = "root";
		String query = "DELETE FROM student WHERE id =" + id;
		
		Connection con = DriverManager.getConnection(url, uname, pass);
		Statement st = con.createStatement();
		st.executeUpdate(query);
		
	}
	
	public void deleteTeacher(int id) throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/miniproject";
		String uname = "root";
		String pass = "root";
		String query = "DELETE FROM teacher WHERE id =" + id;
		
		Connection con = DriverManager.getConnection(url, uname, pass);
		Statement st = con.createStatement();
		st.executeUpdate(query);
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	
	public String setName(String name)
	{
		return this.name = name;
	}
	public String setPassword(String password)
	{
		return this.password = password;
	}
	
	
	public static void main(String[] args) throws Exception 
	{
	    admin a = new admin();
	    a.getdetails("praneeth123");
	    System.out.println(a.getPassword());
	    a.deleteStudent(3);
	    a.deleteTeacher(1);
	}
}
