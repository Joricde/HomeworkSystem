package com.homeworksystem.DAO;


import com.homeworksystem.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StudentDAO {
    Student getStudent(int student_no);
    void modifyPassword(int student_no, String password);
    void changeName(int student_no);
}
