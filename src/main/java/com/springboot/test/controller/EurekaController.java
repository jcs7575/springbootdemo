package com.springboot.test.controller;

import com.springboot.test.service.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Jerry on 16/9/7.
 */
@Controller
@RequestMapping("/v1")
@Api
public class EurekaController {

        @Autowired
        private DiscoveryClient discoveryClient;

        @Autowired
        private RestTemplate restTemplate;

        @Autowired
        private LoadBalancerClient loadBalancerClient;

        @Autowired
        private DemoService demoService;

        /**
         * 通过 Eureka 访问「/」接口返回数据
         * @return
         */
        @ApiOperation(value = "Eureka调用服务", notes = "调用的是「/」接口", response =  String.class)
        @RequestMapping(value = "eureka/list", method = RequestMethod.GET)
        @ResponseBody
        public Object test01() {

                ServiceInstance serviceInstance = loadBalancerClient.choose("SPRINGBOOTDEMO");
                String result = (new RestTemplate()).getForObject(serviceInstance.getUri(),String.class);

                result = restTemplate.getForObject("http://springBootDemo/",String.class);
                return result;
        }

        @ApiOperation(value="测试 Feign",notes = "访问「/v1/hello/{name}」接口",response = String.class)
        @RequestMapping(value = "feign/hello",method = RequestMethod.GET)
        @ResponseBody
        public String testFeign(){
                return demoService.hello("Jerry");
        }
}
