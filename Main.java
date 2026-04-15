/*
	Description :- Inserting large image to database using java application
	Author :- Pranav R Sonawane
*/

package com.jdbc.practice;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        try {
            
            Connection c = ConnectionProvider.getConnection();
            
            String q = "insert into images(pic) values(?)";
            
            PreparedStatement pstmt = c.prepareStatement(q);
            
            // FileChooser is providing dialog box for choose the file 
            JFileChooser jfc = new JFileChooser(); 
            
            jfc.showOpenDialog(null);
            
            File file = jfc.getSelectedFile();
            
            FileInputStream fis = new FileInputStream(file);
            
            pstmt.setBinaryStream(1,fis,fis.available());
            
            pstmt.executeUpdate();
            
            System.out.println("Done....");
            
            JOptionPane.showMessageDialog(null,"Success");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
