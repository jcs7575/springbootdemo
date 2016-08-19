package com.springboot.test.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SpringController {


    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello spring boot";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringController.class,args);
    }

}
