/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.webapp.service.impl;

import com.cibt.webapp.dao.StudentDAO;
import com.cibt.webapp.dao.impl.StudentDAOimpl;
import com.cibt.webapp.entity.Student;
import com.cibt.webapp.service.StudentService;
import java.util.List;

/**
 * 
 * @author ideapad-520S
 */
public class StudentServiceImpl implements StudentService{
    private StudentDAO studentDAO=new StudentDAOimpl();
    private List<Student> students=null;
    @Override
    public List<Student> getAll() throws Exception {
        if(students==null){
            students=studentDAO.getAll();
        }
        return students;
 
    
}
}