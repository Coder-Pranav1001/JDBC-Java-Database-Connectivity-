/*
	Description :- Insert Data to Table with dynamic input
	Author :- Pranav R Sonawane
*/
import java.sql.*;
import java.io.*;

class JDBC4
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

			// BufferedReader Object Creation
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Enter name :");
			String name = br.readLine();

			System.out.println("Enter city :");
			String city = br.readLine();

			// set the value of the query
			pstmt.setString(1,name);
			pstmt.setString(2,city);

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