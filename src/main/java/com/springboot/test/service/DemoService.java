package com.springboot.test.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Jerry on 2016/9/27.
 */
@FeignClient("demoservice")
public interface DemoService {

        @RequestMapping(method= RequestMethod.GET,value = "/hello/{name}")
        String hello(@PathVariable("name") String name);
}
