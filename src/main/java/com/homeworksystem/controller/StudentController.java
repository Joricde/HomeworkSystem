package com.homeworksystem.controller;

import com.homeworksystem.entity.Student;
import com.homeworksystem.result.ServerResult;
import com.homeworksystem.result.data.LoginResult;

import com.homeworksystem.service.StudentService;

import com.homeworksystem.util.WebTokenUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/student/")
public class StudentController {
    @Resource
    private StudentService studentService;

    @PostMapping("/login")
    public ServerResult<LoginResult> loginSubmit(Integer student_no, String password) {

        Student student = studentService.getInfoByStuNo(student_no);
        LoginResult data = new LoginResult();
        ServerResult<LoginResult> serverResult = ServerResult.defaultSuccess(data);
        if(student == null || !password.equals(student.getPassword())) {
            serverResult.setSuccess(false);
            serverResult.setMessage("用户名或密码错误");
        } else {
            serverResult.setSuccess(true);
            serverResult.setMessage("登录成功");
            data.setStudent_no(student.getStudentNo());
            data.setUsername(student.getName());
            String token = WebTokenUtil.getToken(student_no.toString(), password);
            data.setToken(token);
        }
        return serverResult;
    }

}

