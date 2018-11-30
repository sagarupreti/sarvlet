/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.webapp.servlet;

import com.cibt.webapp.dao.StudentDAO;
import com.cibt.webapp.service.StudentService;
import com.cibt.webapp.service.impl.StudentServiceImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
public class HomeServlet extends HttpServlet {
    private StudentService studentService=new StudentServiceImpl();
    private StudentDAO studentDAO;

    
    @Override
    protected void doGet(HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException {
        try{
            
       request.setAttribute("students", 
                    studentService.getAll());
               
       request.setAttribute("student", studentDAO.getByid (4));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        request
                .getRequestDispatcher(
                        "/WEB-INF/views/home.jsp")
                    .forward(request, response);
    }  

}

 