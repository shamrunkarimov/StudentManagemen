/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;

/**
 *
 * @author shamrun
 */
public class LoginRegisterDaoImpl implements LoginRegisterDao{
      
    private String email;
    private String password;
    
    
    public LoginRegisterDaoImpl(String email, String password){
        this.email = email;
        this.password = password;
    }

    @Override
    public List<Student> studentLogin() {
        List<Student> result = new ArrayList();
        Database database = new Database();
        ResultSet resultSet = null;
        try {
            resultSet = database.Connection().executeQuery("select * from student inner join login on student.id = login.student_id where login.email = " + email + " and password= " +password );
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginRegisterDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginRegisterDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setAge(resultSet.getInt("age"));
                student.setLesson_id(resultSet.getInt("lesson_id"));
                result.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginRegisterDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
        
    }
    
    
    
    
}
