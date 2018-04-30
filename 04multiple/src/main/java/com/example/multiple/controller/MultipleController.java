package com.example.multiple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/multiple")
public class MultipleController {

    @RequestMapping("/index")
    @ResponseBody
    public String indexMain(){

        return "";
    }

}
