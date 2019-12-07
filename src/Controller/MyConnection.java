package Controller;


import View.RegisterForm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author catalvasfa_sd2022
 */
public class MyConnection {
    
        public static Connection getConnection(){
        
        Connection con = null;
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/fayedb?serverTimezone=UTC","root","");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return con; 
    }
        
        //function to check if the username already exist
    public boolean checkUsername(String username) {
        PreparedStatement ps;
        ResultSet rs;
        boolean checkUser = false;
        String query = "SELECT * FROM `user` WHERE `username` =?";

        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setString(1, username);

            rs = ps.executeQuery();

            if (rs.next())
            {
                checkUser = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return checkUser;
    }

}

    





