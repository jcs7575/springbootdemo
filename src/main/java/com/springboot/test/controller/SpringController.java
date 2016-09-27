package com.springboot.test.controller;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableEurekaClient
public class SpringController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    String home() {
        return "Hello spring boot";
    }

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    @ResponseBody
    String hello(@PathVariable("name") String name) {
        return "Hello 「" + name+"」";
    }
}
