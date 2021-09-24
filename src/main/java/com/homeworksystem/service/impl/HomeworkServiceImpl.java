package com.homeworksystem.service.impl;

import com.homeworksystem.DAO.HomeworkDAO;
import com.homeworksystem.entity.HomeWork;
import com.homeworksystem.service.HomeworkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class HomeworkServiceImpl implements HomeworkService {
    @Resource
    private HomeworkDAO homeworkDAO;
    public HomeWork getInfoByStuNo(int student_no){

        return homeworkDAO.getHomeWorkByStu(student_no);
    }
}
