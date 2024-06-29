/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvt.services;

import com.nvt.jbdcthang.JdbcUtils;
import com.nvt.pojo.Choice;
import com.nvt.pojo.Question;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class QuestionService {

    public List<Question> getQuestions(int n) throws SQLException {
        try ( Connection conn = JdbcUtils.getConn()) {
            CallableStatement stm = conn.prepareCall("{ Call get_questions(?)}");
            stm.setInt(1, n);
            ResultSet rs = stm.executeQuery();

            List<Question> questions = new ArrayList<>();
            while (rs.next()) {
                questions.add(new Question(rs.getString("id"), rs.getString("content"), rs.getInt("category_id")));
            }

            return questions;
        }
    }

    public List<Choice> getChoices(String quesId) throws SQLException {
        try ( Connection conn = JdbcUtils.getConn()) {
            CallableStatement stm = conn.prepareCall("{ Call get_choices{?} }");
            stm.setString(1, quesId);
            ResultSet rs = stm.executeQuery();

            List<Choice> choices = new ArrayList<>();
            while (rs.next()) {
                choices.add(new Choice(rs.getString("id"), rs.getString("content"), rs.getBoolean("is_correct"), rs.getString("question_id")));
            }

            return choices;
        }
    }

    public int countQuestion() throws SQLException {
        try ( Connection conn = JdbcUtils.getConn()) {
            CallableStatement stm = conn.prepareCall("{ Call count_questions(?) }");
            stm.registerOutParameter(1, Types.INTEGER);
            stm.execute();

            int a = stm.getInt(1);
            return a;
        }
    }

}
