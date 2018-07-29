package com.zm.springboot_task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @Describle This Class Is 异步任务
 * @Author ZengMin
 * @Date 2018/7/29 10:26
 */
@Service
public class AsyncTask {

    @Async  //表明此方法是异步的
    public void testAsync() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Task execute...");
    }

//    @Scheduled(cron = "0 * * * * ?")    //每整分执行一次
//    @Scheduled(cron = "0-59 * * * * ?")    //0-59秒 每秒执行一次
    @Scheduled(cron = "0/5 * * * * ?")      //每五秒执行一次
    public void testTimer(){
        System.out.println("Scheduled execute....");
    }
}
