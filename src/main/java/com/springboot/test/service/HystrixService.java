package com.springboot.test.service;

/**
 * Created by Jerry on 2016/9/28.
 */
public interface HystrixService {

        String getRemoteHelloWorld();

        String getLocalHelloWorld();
}
