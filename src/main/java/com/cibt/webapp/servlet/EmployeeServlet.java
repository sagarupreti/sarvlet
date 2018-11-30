 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.webapp.servlet;

import com.cibt.webapp.dao.EmployeeDAO;
import com.cibt.webapp.dao.impl.EmployeeDAOimpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ideapad-520S
 */
@WebServlet(name = "empServlet",urlPatterns = {"/emp"})
public class EmployeeServlet extends HttpServlet{
    private EmployeeDAO empDAO= new EmployeeDAOimpl();
    
    @Override
    protected void doGet(HttpServletRequest request, 
            HttpServletResponse respsponse) throws ServletException, IOException {
        try{
        request.setAttribute("employees", 
                empDAO.getAll());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        request.getRequestDispatcher("/WEB-INF/views/employees/index.jsp")
                 .forward(request, respsponse);
    }
    
    
}
