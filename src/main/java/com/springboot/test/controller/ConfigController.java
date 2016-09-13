package com.springboot.test.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Jerry on 2016/9/13.
 */
@Controller
@RequestMapping("/v1/config")
@Api
@RefreshScope
public class ConfigController {

        @Value("${from}")
        private String from;

        @ApiOperation(value = "通过读取 ConfigServer 获取配置信息", notes = "", response = String.class)
        @RequestMapping(value = "/info",method = RequestMethod.GET)
        @ResponseBody
        public Object save(){

                return from;
        }

        public String getFrom() {
                return from;
        }

        public void setFrom(String from) {
                this.from = from;
        }
}
