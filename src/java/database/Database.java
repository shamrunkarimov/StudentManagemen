/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shamrun
 */
public class Database {
        public Connection connect = null;
        private Statement statement = null;
        private PreparedStatement preparedStatement = null;
        private ResultSet resultSet = null;

        
        
    public Statement Connection() throws ClassNotFoundException, SQLException{
        List sd = new ArrayList();
        Class.forName("com.mysql.jdbc.Driver");  
        Connection connect=DriverManager.getConnection(  
        "jdbc:mysql://localhost/school","root","");
        statement = connect.createStatement();
        return statement;
    }  
    
     
       
    
}
