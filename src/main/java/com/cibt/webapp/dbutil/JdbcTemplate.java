/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.webapp.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ideapad-520S
 */
public class JdbcTemplate<T> {
    private DbConnection db=new DbConnection();
    private PreparedStatement stmt=null;
    
    private JdbcTemplate<T> prepare(String sql)throws Exception{
        db.connect();
        stmt=db.initStatement(sql);
        return this;
        
    }
     
   public List<T> query(String sql, RowMapper<T> mapper) throws
           Exception{
       List<T> rows=new ArrayList<>();
        prepare(sql);
        ResultSet rs=db.query();
        while(rs.next()){
            rows.add(mapper.mapRow(rs));
        }
        db.close();
        return rows;
        
   }
   public List<T> query(String sql,Object[] params,RowMapper<T> mapper) throws
           Exception{
       List<T> rows=new ArrayList<>();
        prepare(sql).setParameters(stmt, params);
        
        ResultSet rs=db.query();
        while(rs.next()){
            rows.add(mapper.mapRow(rs));
        }
        db.close();
        return rows;
        
   }
   
   public T queryForObject(String sql,Object[] params,
           RowMapper<T> mapper)throws Exception{
      List<T> rows = query(sql, params, mapper);
       return(rows != null) ? rows.get(0) : null;
       
   }
   
   public void setParameters(PreparedStatement stmt,
           Object[] params) throws Exception{
       int counter=1;
        for(Object p:params){
            stmt.setObject(counter, p);
            counter++;
        }
   }
   
   public int update(String sql, Object[] params)throws 
           Exception{
        prepare(sql).setParameters(stmt, params);
        int result=db.update();
        db.close();  
        return result;     

       
        
  }
}
