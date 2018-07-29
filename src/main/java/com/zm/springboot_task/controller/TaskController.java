package com.zm.springboot_task.controller;

import com.zm.springboot_task.service.AsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2018/7/29 10:28
 */
@RestController
public class TaskController {

    @Autowired
    AsyncTask asyncTask;

    @GetMapping("/async")
    public String say() throws InterruptedException {
        asyncTask.testAsync();
        return "success";
    }

}
