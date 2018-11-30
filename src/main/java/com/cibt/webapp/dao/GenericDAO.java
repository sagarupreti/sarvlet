/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.webapp.dao;

import java.util.List;

/**
 *
 * @author ideapad-520S
 */
public interface GenericDAO<T> {
    int insert(T model)throws Exception;
    int update(T model)throws Exception;
    int delete(int id)throws Exception;
    T getByid(int id)throws Exception;
    List<T> getAll () throws Exception;
}
