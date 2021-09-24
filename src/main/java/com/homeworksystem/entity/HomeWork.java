package com.homeworksystem.entity;

import java.util.Date;

import lombok.Data;

@Data
public class HomeWork {
    private int courseNo;
    private int studentNo;
    private int homeworkNo;
    private String fileName;
    private String content;
    private double score;
    private Date start;
    private Date end;

}
