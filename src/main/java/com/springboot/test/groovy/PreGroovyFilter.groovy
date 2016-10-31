package com.springboot.test.groovy

import com.netflix.zuul.ZuulFilter

/**
 * Created by Jerry on 2016/10/31.
 */
class PreGroovyFilter extends ZuulFilter{

    @Override
    String filterType() {
        return "pre"
    }

    @Override
    int filterOrder() {
        return 2
    }

    @Override
    boolean shouldFilter() {
        return true
    }

    @Override
    Object run() {
        println("Here is Groovy filter!!!!")
        return null
    }
}
