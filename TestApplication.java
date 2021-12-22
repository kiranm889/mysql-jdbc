package com.sql.create;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestApplication 
{
	static final String driver = "com.mysql.cj.jdbc.Driver";
	static final String url = "jdbc:mysql://localhost:3306/sample";
	static final String username = "root";
	static final String password = "root";
	
	
	
	
	public static void main(String[] args) 
	{
		
		try {
			
			Class.forName(driver);
			
			
			Connection con = DriverManager.getConnection(url, username, password); 
			Statement stmt =con.createStatement();
			
//			CREATE TABLE
			/*
			 * String sql="create table bank"+"(h_id INT,"+"f_name varchar(20),"
			 * +"l_name varchar(20),"+"age INT);";
			 * 
			 * stmt.executeUpdate(sql);
			 * 
			 * System.out.println("Created table sucessfully");
			 */
			
			
//			INSERT INTO TABLES
			PreparedStatement stmt1 = con.prepareStatement("insert into bank values(?,?,?,?);");
		    stmt1.setInt(1, 104); 
		    stmt1.setString(2, "Pangala"); 
		    stmt1.setString(3, "Bhupati");
		    stmt1.setInt(4, 29);
		    stmt1.executeUpdate();
	
		    System.out.println("INSERTED SUCCESFULLY");
		    
		    
		    
//		    UPDATE TABLE CONTENTS
		    String up="UPDATE bank"+" set age=10 where h_id=101";
		    stmt.executeUpdate(up);
		    
		    
		    
//		    DELETE ROW IN TABLE
		    String del="delete from bank where h_id=104";
		    stmt.executeUpdate(del); 
		    System.out.println("deleted the rows of h_id=101");
		    
		   
		    
		    
//		    SELECT * FROM TABLE
		    
		    ResultSet rs=stmt.executeQuery("select * from bank;");
		    
		    System.out.println("h_id---f_name-------l_name--------age");
		    while(rs.next())
		    {
		    	System.out.println(rs.getInt(1)+"   "+rs.getString(2)+"      "+rs.getString(3)+"     "+rs.getInt(4));
		    }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}

}
