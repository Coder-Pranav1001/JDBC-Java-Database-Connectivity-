/*
	Description :- Inserting image to database using Java
	Author :- Pranav R Sonawane
*/
import java.sql.*;
import java.io.*;

class JDBC5
{
	public static void main(String args[])
	{
		try
		{	
			// load the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// create connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/marvellous","root","root");
			
			// create a query
			String q = "insert into images(pic) values(?)";
			
			// get the PreparedStatement object 
			PreparedStatement pstmt = con.prepareStatement(q);	

			// object creation of FileInputStream
			FileInputStream fis = new FileInputStream("Profile.jpeg");

			// image is byte type
			pstmt.setBinaryStream(1,fis,fis.available()); //position, object, fis.available = return numbers of available bytes

			pstmt.executeUpdate();

			System.out.println("done...");
		}
		catch(Exception e)
		{
			System.out.println("Error !!");
		}
	}
}