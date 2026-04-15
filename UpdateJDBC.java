/*
	Description :-  Updating data of table in database using java application
	Author :- Pranav R Sonawane
*/
package com.jdbc.practice;

import java.sql.*;
import java.io.*;

public class UpdateJDBC {
    public static void main(String[] args) {
        try{
        
            Connection con = ConnectionProvider.getConnection(); // return the object of connection
            
            String q = "update table1 set tName=?, tCity=? where tId=?";
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            System.out.println("Enter new name : ");
            String name = br.readLine();
            
            System.out.println("Enter new city : ");
            String city = br.readLine();
            
            System.out.println("Enter the student id : ");
            int id = Integer.parseInt(br.readLine());
            
            PreparedStatement pstmt = con.prepareStatement(q);
            
            pstmt.setString(1, name);
            pstmt.setString(2, city);
            
            pstmt.setInt(3, id);
            
            pstmt.executeUpdate();
            
            System.out.println("done.....");
            
            con.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
