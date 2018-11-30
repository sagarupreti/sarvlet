/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.webapp.dao.impl;

import com.cibt.webapp.dao.EmployeeDAO;
import com.cibt.webapp.dbutil.JdbcTemplate;
import com.cibt.webapp.dbutil.RowMapper;
import com.cibt.webapp.entity.Employee;
import com.cibt.webapp.entity.Employee;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author ideapad-520S
 */
public class EmployeeDAOimpl implements EmployeeDAO {
    private JdbcTemplate<Employee> template=
            new JdbcTemplate<>();
    @Override
    public int insert(Employee model) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Employee model) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Employee getByid(int in) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Employee> getAll() throws Exception {
         return template.query("select * from employees",
                new RowMapper<Employee>() {

                    @Override
                    public Employee mapRow(ResultSet rs) throws Exception {
                        Employee employee = new Employee();
                        employee.setId(rs.getInt("id"));
                        employee.setFirstName(rs.getString("first_name"));
                        employee.setLastName(rs.getString("last_name"));
                        employee.setEmail(rs.getString("email"));
                        employee.setContactNo(rs.getString("contact_no"));
                        employee.setAddedDate(rs.getDate("added_date"));
                        employee.setStatus(rs.getBoolean("status"));
                        
                        return employee;
                    }
                });
    }
    
}
