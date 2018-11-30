  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.webapp.dbutil;

import java.sql.ResultSet;

/**
 *
 * @author ideapad-520S
 */
public interface RowMapper<T> {
    T mapRow(ResultSet rs)throws Exception;
}
