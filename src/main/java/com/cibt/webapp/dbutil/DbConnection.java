/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.webapp.dbutil;

import com.cibt.webapp.constant.DbConstant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ideapad-520S
 */
public class DbConnection {
    private Connection conn=null;
    private PreparedStatement stmt=null;
    
    
    public void connect() throws Exception{
        Class.forName(DbConstant.DB_DRIVER);
       
        conn=DriverManager
                .getConnection(DbConstant.DB_URL, 
                        DbConstant.DB_USER, 
                        DbConstant.DB_PASSWORD);
        
    }
    
    public PreparedStatement initStatement(String Sql) throws SQLException{
        stmt=conn.prepareStatement(Sql);
        return stmt;
    }
    
    public ResultSet query() throws SQLException{
        return stmt.executeQuery();
    }
    public int update()throws SQLException{
        return stmt.executeUpdate();
                
    }
    
    public void close() throws SQLException{
        if(!conn.isClosed() && conn!=null){
            conn.close();
            conn=null;
            stmt=null;
        }
    }
}
