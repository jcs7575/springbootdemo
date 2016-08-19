package com.springboot.test.core;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by Jerry on 16/8/12.
 */
@Configuration
public class WebApiConfiguration extends WebMvcConfigurerAdapter {


    //private JsonMessageConverter jsonMessageConverter;

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        //converters.clear();
        //converters.add(0,new JsonMessageConverter());
        converters.forEach((convert) -> System.out.println(convert.getClass()));

    }
}
