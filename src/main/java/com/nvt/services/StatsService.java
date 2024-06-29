/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvt.services;

import com.nvt.jbdcthang.JdbcUtils;
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
public class StatsService {
    public List<Object[]> stats() throws SQLException{
        try(Connection conn = JdbcUtils.getConn()){
            CallableStatement stm = conn.prepareCall("{ call stats() }");
            List<Object[]> results = new ArrayList<>();
            ResultSet rs = stm.executeQuery();
            while(rs.next())
                results.add(new Object[] {rs.getInt(1), rs.getString(2), rs.getInt(3)});
            
            
            return  results;
        }
    }
}
