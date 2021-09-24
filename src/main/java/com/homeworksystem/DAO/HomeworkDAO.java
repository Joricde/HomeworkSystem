package com.homeworksystem.DAO;

import com.homeworksystem.entity.HomeWork;
import com.homeworksystem.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface HomeworkDAO {
    HomeWork getHomeWorkByStu(int student_no);
    HomeWork submitHomeWorkByStu(int student_no);
    HomeWork correctHomeworkByTeacher(int student_no);

}
