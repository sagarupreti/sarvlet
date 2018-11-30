 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.webapp.dao.impl;

import com.cibt.webapp.dao.StudentDAO;
import com.cibt.webapp.dbutil.DbConnection;
import com.cibt.webapp.dbutil.JdbcTemplate;
import com.cibt.webapp.dbutil.RowMapper;
import com.cibt.webapp.entity.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author ideapad-520S
 */
public class StudentDAOimpl implements StudentDAO {

    private JdbcTemplate<Student> template = new JdbcTemplate();
    private DbConnection db = new DbConnection();

    @Override
    public int insert(Student model) throws Exception {
        String sql = "insert into students(first_name,"
                + "last_name,email,contact_no,status) values(?,?,?,?,?)";
        return template
                .update(sql, new Object[]{
                    model.getFirstName(),
                    model.getLastName(),
                    model.getEmail(),
                    model.getContactNo(),
                    model.isStatus(),});

    }

    @Override
    public int update(Student model) throws Exception {
        String sql = "update  students set first_name=?,"
                + "last_name=?,email=?,contact_no=?,"
                + "status=? where id=?";
        return template
                .update(sql, new Object[]{
                    model.getFirstName(),
                    model.getLastName(),
                    model.getEmail(),
                    model.getContactNo(),
                    model.isStatus(),
                    model.getId()
                });
    }

    @Override
    public int delete(int id) throws Exception {
        String sql = "delete from students where id=?";
        return template
                .update(sql, new Object[]{id});
    }

    @Override
    public Student getByid(int id) throws Exception {
        String sql = "select * from students where id=?";
        return template.queryForObject(sql, new Object[]{id}, new RowMapper<Student>() {

                    @Override
                    public Student mapRow(ResultSet rs) throws Exception {
                        Student student = new Student();
                        student.setId(rs.getInt("id"));
                        student.setFirstName(rs.getString("first_name"));
                        student.setLastName(rs.getString("last_name"));
                        student.setEmail(rs.getString("email"));
                        student.setContactNo(rs.getString("contact_no"));
                        student.setAddedDate(rs.getDate("added_date"));
                        student.setStatus(rs.getBoolean("status"));
                        return student;
                    }
                });
    }

    @Override
    public List<Student> getAll() throws Exception {
        return template.query("select * from students",
                new RowMapper<Student>() {

                    @Override
                    public Student mapRow(ResultSet rs) throws Exception {
                        Student student = new Student();
                        student.setId(rs.getInt("id"));
                        student.setFirstName(rs.getString("first_name"));
                        student.setLastName(rs.getString("last_name"));
                        student.setEmail(rs.getString("email"));
                        student.setContactNo(rs.getString("contact_no"));
                        student.setAddedDate(rs.getDate("added_date"));
                        student.setStatus(rs.getBoolean("status"));

                        return student;
                    }
                });

    }

}
