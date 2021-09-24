package com.homeworksystem.service;

import com.homeworksystem.entity.HomeWork;
import com.homeworksystem.entity.Student;

public interface HomeworkService {
    HomeWork getInfoByStuNo(int student_no);
}
