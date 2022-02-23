package com.example.test.config;

import com.example.test.service.ExecuteTimer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Timer {

    @Autowired
    private ExecuteTimer executeTimer;

    @Scheduled(cron = "0 */2 * * * ?") //每2分钟
    public void executeTimer(){
        executeTimer.executeTimer1();
        System.out.println("cron打印时间："+new Date());
    }


}
