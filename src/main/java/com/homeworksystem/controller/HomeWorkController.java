package com.homeworksystem.controller;

import com.homeworksystem.result.ServerResult;
import com.homeworksystem.result.data.SubmitResult;

import com.homeworksystem.service.HomeworkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;


@RestController
@RequestMapping("/api/student/specific/")
public class HomeWorkController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeWorkController.class);

    @Resource
    private HomeworkService homeworkService;
    @PostMapping("/submit")
    public ServerResult<SubmitResult> loginSubmit(Integer student_no, @RequestParam("file") MultipartFile multipartFile) {

        SubmitResult data = new SubmitResult();
        ServerResult<SubmitResult> serverResult = ServerResult.defaultSuccess(data);
        if (multipartFile.isEmpty()) {
            serverResult.setMessage("文件为空！");
            serverResult.setSuccess(false);
        } else {
            String fileName = multipartFile.getOriginalFilename();
            String filePath = "C:\\Users\\YOU\\IdeaProjects\\HomeworkSystem\\src\\main\\java\\com\\homeworksystem\\homework";
            File dest = new File(filePath + fileName);
            try {
                multipartFile.transferTo(dest);
                LOGGER.info("文件f" + fileName + "上传成功");
                data.setSubmit(true);
            } catch (IOException e) {
                LOGGER.error(e.toString(), e);
                data.setSubmit(false);
            }
        }
        data.setStudent_no(student_no);
        return serverResult;
    }

}
