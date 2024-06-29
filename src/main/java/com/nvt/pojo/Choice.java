/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvt.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author admin
 */
@Data
@AllArgsConstructor
public class Choice {
    private String id;
    private String  content;
    private Boolean is_correct;
    private String question_id;
}
