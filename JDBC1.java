/*
	Description :- Load the Diver and create connection with database
	Author :- Pranav R Sonawane
*/

import java.sql.*;

class JDBC1
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

			if(con.isClosed())
			{
				System.out.println("Connection is closed");
			}
			else
			{
				System.out.println("Connection created...");
			}



		}
		catch(Exception obj)
		{
			System.out.println(obj);
		}
	}
}