/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvt.services;

import com.nvt.jbdcthang.Jbdcthang;
import com.nvt.jbdcthang.JdbcUtils;
import com.nvt.pojo.Category;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class CategoryService {
   public List<Category> getCates() throws SQLException{
       try(Connection conn = JdbcUtils.getConn()){
           CallableStatement stm = conn.prepareCall("{ Call get_cates()}");
           ResultSet rs = stm.executeQuery();
           
           List<Category> cates = new ArrayList<>();
            while(rs.next())
               cates.add(new Category(rs.getInt("id"), rs.getString("name")));
            
            return cates;
       }
   }
}
