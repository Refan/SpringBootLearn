package com.example.scheduled.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** 
* @Description: application進入點需要新增 @EnableScheduling
* @Param:  
* @return:  
* @Author: Neil.Fan
* @Date: 2018/5/2 
*/ 
@Controller
public class ScheduledController {

    @RequestMapping(value = { "", "/", "/index" })
    @ResponseBody
    public String main() {
        System.out.println("test");
        return "test";
    }

    /**
     * 以下三種可以用：
     * fixedRate makes Spring run the task on periodic intervals even if the last invocation may be still running.
     * fixedDelay specifically controls the next execution time when the last execution finishes.
     * cron is a feature originating from Unix cron utility and has various options based on your requirements.
     *
     * cron - 固定的時間或週期，週期式行為同 fixedRate
     * 固定六個值：秒(0-59) 分(0-59) 時(0-23) 日(1-31) 月(1-12) 週(1,日-7,六)
     * 日與週互斥，其中之一必須為 ?
     * 可使用的值有：單一數值（26）、範圍（50-55）、清單（9,10）、不指定（*）與週期（*\/ 3）
    **/
    @Scheduled(cron = "*/10 * * * * ?")
    public void scheduledMain(){
        System.out.println("每分鐘執行一次");

    }

}
