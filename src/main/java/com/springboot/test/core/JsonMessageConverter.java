package com.springboot.test.core;

import com.fasterxml.jackson.core.JsonGenerator;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.json.JsonSimpleJsonParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by Jerry on 16/8/12.
 */
//@Component
public class JsonMessageConverter extends AbstractHttpMessageConverter<Object> {

    @Override
    protected boolean supports(Class<?> aClass) {
        return !aClass.isPrimitive();
        //return true;
    }

    public JsonMessageConverter() {
        super(MediaType.APPLICATION_JSON_UTF8);
    }

    @Override
    protected Object readInternal(Class<?> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    protected void writeInternal(Object o, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        httpOutputMessage.getHeaders().add("Content-Type", "application/json");
        httpOutputMessage.getBody().write("{".getBytes());
        httpOutputMessage.getBody().write(toJson(o).getBytes());
        httpOutputMessage.getBody().write("}".getBytes());
        httpOutputMessage.getBody().flush();
    }


    private String toJson(Object o) {
        return "hello jerry";
    }
}
