/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.nvt.jbdcthang;

import com.nvt.pojo.Choice;
import com.nvt.pojo.Question;
import com.nvt.services.CategoryService;
import com.nvt.services.QuestionService;
import com.nvt.services.StatsService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class Jbdcthang {

    public static void main(String[] args) throws SQLException {
        // Fetch Category
//        CategoryService s = new CategoryService();
//        s.getCates().forEach(q -> System.out.println(q.getName()));
//
//        System.out.println("---------------------------------------------");
//
//        // Fetch Question and Choice
//        QuestionService k = new QuestionService();
//        List<Question> questions = k.getQuestions(2);
//        Scanner sc = new Scanner(System.in);
//        questions.forEach(q -> {
//            System.out.println(q.getContent());
//
//            try {
//                List<Choice> choices = k.getChoices(q.getId());
//                for (int i = 0; i < choices.size(); i++) {
//                    System.out.printf("%d. %s\n", i + 1, choices.get(i).getContent());
//                }
//                System.out.printf("Nhap vao lua chon cua ban: ");
//                int ans = sc.nextByte();
//
//                if (choices.get(ans - 1).getIs_correct() == true) {
//                    System.out.println("Chinh xac !!!");
//                } else {
//                    System.out.println("Saii !!!");
//                }
//
//            } catch (SQLException ex) {
//                Logger.getLogger(Jbdcthang.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        });
        StatsService s = new StatsService();
        s.stats().forEach(o -> System.out.printf("%d - %s: %d\n", o[0],o[1],o[2]));
        
        
        QuestionService k = new QuestionService();
        System.out.println("So luong cau hoi: " + k.countQuestion());
    }
}
