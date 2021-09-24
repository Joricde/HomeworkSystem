package com.homeworksystem.DAO;

import com.homeworksystem.entity.Course;

import java.util.List;

public interface CourseDAO {

    List<Course> getCourseByStuAccount(int account);
    List<Course> getCourseByTeacherAccount(int account);
    void createCourse(Course course);

}
