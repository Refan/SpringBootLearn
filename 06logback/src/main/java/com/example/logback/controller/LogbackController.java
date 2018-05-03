package com.example.logback.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** 
* @Description: 需要特別載入lombok才能使用slf4j注解
* @Param:  
* @return:  
* @Author: Neil.Fan
* @Date: 2018/5/3 
*/ 
@Slf4j
@Controller
@RequestMapping("/logback")
public class LogbackController {

    @RequestMapping("/index")
    @ResponseBody
    public String testCreate(){

        //log輸出級別 TRACE < DEBUG < INFO < WARN < ERROR < FATAL
        log.trace("===log輸出 TRACE");
        log.debug("===log輸出 DEBUG");
        log.info("===log輸出 INFO");
        log.warn("===log輸出 WARN");
        log.error("===log輸出 ERROR");

        return "logback";
    }


    @Scheduled(cron = "0 */1 * * * ?")
    public void scheduledMain(){
        System.out.println("每分鐘執行一次");

        log.trace("===log輸出 TRACE");
        log.debug("===log輸出 DEBUG");
        log.info("===log輸出 INFO");
        log.warn("===log輸出 WARN");
        log.error("===log輸出 ERROR");
    }

}
