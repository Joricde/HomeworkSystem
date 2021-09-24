package com.homeworksystem.service;

import com.homeworksystem.entity.Student;

public interface StudentService {

    Student getInfoByStuNo(int student_no);
    boolean checkPassword(Integer student_no, String password);
}
