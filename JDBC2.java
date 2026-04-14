/*
	Description :- Create table in database using java program
	Author :- Pranav R Sonawane
*/

import java.sql.*;

class JDBC2
{
	public static void main(String args[])
	{
		try
		{
			// load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// create connection
			String url = "jdbc:mysql://localhost:3306/marvellous";
			String username = "root";
			String password = "root";

			Connection con = DriverManager.getConnection(url,username,password);

			// create a query
			String q = "create table table1(tId int(20) primary key auto_increment, tName varchar(100) not null , tCity varchar(100))";
			
			// create statement
			Statement stmt=con.createStatement();

			stmt.executeUpdate(q);

			System.out.println("Table created in database...");

			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}