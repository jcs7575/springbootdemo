package com.springboot.test.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;

/**
 * Created by Jerry on 2016/10/27.
 */
public class RoutingFilter extends ZuulFilter {
        @Override
        public String filterType() {
                return "route";
        }

        @Override
        public int filterOrder() {
                return 1;
        }

        @Override
        public boolean shouldFilter() {
                return true;
        }

        @Override
        public Object run() {
                try {
                        String uri = RequestContext.getCurrentContext().getRequest().getRequestURI();
                        if (StringUtils.contains(uri, "/zuulfilter/filter/redirect")) {
                                RequestContext.getCurrentContext().getResponse()
                                        .sendRedirect("https://github.com/jcs7575/springbootdemo");
                        }
                } catch (IOException e) {
                        e.printStackTrace();
                }
                return null;
        }
}
