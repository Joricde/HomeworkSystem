package com.homeworksystem.service.impl;

import com.homeworksystem.DAO.StudentDAO;
import com.homeworksystem.entity.Student;
import com.homeworksystem.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDAO studentDAO;
    @Override
    public Student getInfoByStuNo(int student_no){
        return studentDAO.getStudent(student_no);
    }
    @Override
    public boolean checkPassword(Integer student_no, String password){
        Student student = studentDAO.getStudent(student_no);
        return password.equals(student.getPassword());
    }

}
