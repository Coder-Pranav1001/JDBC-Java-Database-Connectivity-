/*
	Description :- Load the Driver and Create the Connection the provide connection  
	Author :- Pranav R Sonawane
*/

package com.jdbc.practice;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Pranav Sonawane
 */
public class ConnectionProvider {
    private static Connection con;
    
    public static Connection getConnection()
    {
        try
        {
           if(con == null)
           {
               Class.forName("com.mysql.cj.jdbc.Driver");

               con = DriverManager.getConnection("jdbc:mysql://localhost:3306/marvellous","root","root");
           }
        }
       
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        
        return con;
    }
}
