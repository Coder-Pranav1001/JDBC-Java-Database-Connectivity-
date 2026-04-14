/*
	Description :- Insert data into table using Prepared Statement
	Author :- Pranav R Sonawane
*/
import java.sql.*;

class JDBC3
{
	public static void main(String args[])
	{
		try
		{	
			// load the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// create connection
			String url = "jdbc:mysql://localhost:3306/marvellous";
			String username = "root";
			String password = "root";

			Connection con = DriverManager.getConnection(url,username,password);

			// create a query
			String q = "insert into table1(tName,tCity) values(?,?)"; // Dynamic query , Parameterise query

			// get the PreparedStatement object 
			PreparedStatement pstmt = con.prepareStatement(q);

			// set the value of the query
			pstmt.setString(1,"Pranav Sonawane");
			pstmt.setString(2,"Pune");

			pstmt.executeUpdate();

			System.out.println("inserted...");

			con.close();
		}


		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}