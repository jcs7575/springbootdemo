package com.springboot.test.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jerry on 2016/9/28.
 */
@Service
public class HystrixServiceImpl implements HystrixService{

        int count = 0;
        @Autowired
        private DemoService demoService;

        @Override
        @HystrixCommand(groupKey = "HystrixOne", fallbackMethod = "getDefaultHelloWorld")
        public String getRemoteHelloWorld() {
                return demoService.hello("Jerry");
        }

        @Override
        @HystrixCommand(commandProperties = {
                @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "1"),
                @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE"),
                @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value="5")
        })
        public String getLocalHelloWorld() {
                if(count <2 || count > 5){
                        count++;
                        return "hi Hystrix";
                }
                count++;
                throw new RuntimeException("local error");
        }

        private String getDefaultHelloWorld(){

                return "Hello Hystrix";
        }

        private String getDefaultLocalHelloWorld(){
                return "Hello Hystrix from local";
        }


}
