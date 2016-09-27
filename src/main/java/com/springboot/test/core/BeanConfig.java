package com.springboot.test.core;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Jerry on 2016/9/22.
 */
@Configuration
public class BeanConfig {

        @Bean
        @LoadBalanced
        public RestTemplate restTemplate() {
                RestTemplate template = new RestTemplate();
                SimpleClientHttpRequestFactory factory = (SimpleClientHttpRequestFactory) template.getRequestFactory();
                factory.setConnectTimeout(3000);
                factory.setReadTimeout(3000);
                return template;
        }
}
