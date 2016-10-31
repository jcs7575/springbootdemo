package com.springboot.test;

import com.springboot.test.filter.PreZuulFilter;
import com.springboot.test.filter.RoutingFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * Created by Jerry on 16/8/1.
 */
@SpringBootApplication
@MapperScan(basePackages = "com.springboot.test.dao")
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard
@EnableZuulProxy
public class InitSpringBoot extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(InitSpringBoot.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(InitSpringBoot.class, args);
//        new SpringApplicationBuilder(InitSpringBoot.class).web(true).run(args);
    }

    @Bean
    public RoutingFilter routingFilter(){
        return new RoutingFilter();
    }

    @Bean
    public PreZuulFilter preFilter(){
        return new PreZuulFilter();
    }
}
