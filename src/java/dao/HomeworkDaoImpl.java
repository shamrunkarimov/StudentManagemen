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
import model.Lesson;
import model.Student;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author shamrun
 */
public class HomeworkDaoImpl implements HomeworkDao {
    
    private String name;
  

    public HomeworkDaoImpl() {
    }
    
    public HomeworkDaoImpl(String name){
        this.name = name;
    }
    
    
    @Override
    public List<Student> getStudentsByLesson(){
        List<Student> result = new ArrayList();
        Database database = new Database();
        ResultSet resultSet = null;
        try {
            resultSet = database.Connection().executeQuery("select * from student inner join lesson on lesson.id = student.lesson_id where lesson.name = " + name );
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(HomeworkDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HomeworkDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(HomeworkDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
        
    }
    @Override
    public List<Lesson> getAll() {
        List<Lesson> result = new ArrayList();
        Database database = new Database();
        ResultSet resultSet = null;
        try {
            resultSet = database.Connection().executeQuery("select id from lesson where id = 1 ");
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(HomeworkDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HomeworkDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        
        try {
            while(resultSet.next()){
                Lesson lesson = new Lesson();
                lesson.setId(resultSet.getInt("id"));
                //lesson.setName(resultSet.getString("name"));
                result.add(lesson);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HomeworkDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
        
        
    }      
    
}
