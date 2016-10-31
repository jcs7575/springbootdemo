package com.springboot.test.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Jerry on 2016/10/27.
 */
@Controller
@RequestMapping("/v1")
@Api
public class ZuulTestController {

        @Autowired
        private HttpServletRequest httpServletRequest;

        /**
         * 运行 zuul 的 pre filter
         * @return
         */
        @ApiOperation(value = "测试 Zuul pre filter", notes = "filter 将会在 request 中添加 name=zuul", response =  String.class)
        @RequestMapping(value = "/filter/pre", method = RequestMethod.GET)
        @ResponseBody
        public Object pre() {

                return "Hi zuul pre filter!";
        }

        /**
         * 运行 zuul 的 routing filter
         * @return
         */
        @ApiOperation(value = "测试 Zuul routing filter", notes = "routing filter 将会直接 redirect 到 github 上", response =  String.class)
        @RequestMapping(value = "/filter/redirect", method = RequestMethod.GET)
        @ResponseBody
        public Object routing() {
                System.out.println("can not arrive here");
                return null;
        }
}
