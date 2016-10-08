package com.springboot.test.controller;

import com.springboot.test.service.HystrixService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Jerry on 2016/9/29.
 */
@Controller
@RequestMapping("/v1")
@Api
public class HystrixController {

        @Autowired
        private HystrixService hystrixService;

        @ApiOperation(value = " Hystrix调用服务", notes = "正常响应", response =  String.class)
        @RequestMapping(value = "/hystrix/ok", method = RequestMethod.GET)
        @ResponseBody
        public Object getHystrixRemote() {
                return hystrixService.getRemoteHelloWorld();
        }

        @ApiOperation(value = " Hystrix调用服务", notes = "异常响应", response =  String.class)
        @RequestMapping(value = "/hystrix/error", method = RequestMethod.GET)
        @ResponseBody
        public Object getHystrixLocal() {
                return hystrixService.getLocalHelloWorld();
        }

}

