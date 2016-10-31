package com.springboot.test.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Jerry on 2016/10/28.
 */
public class PreZuulFilter extends ZuulFilter {
        private static Logger log = LoggerFactory.getLogger(PreZuulFilter.class);

        @Override
        public String filterType() {
                return "pre";
        }

        @Override
        public int filterOrder() {
                return 1;
        }

        /**
         * 在这个方法里面可以指定过滤器生效的条件
         * @return
         */
        @Override
        public boolean shouldFilter() {
//                RequestContext ctx = RequestContext.getCurrentContext();
//                String requestUri = ctx.getRequest().getRequestURI();
//                return requestUri.startsWith("/available");
                return true;
        }

        @Override
        public Object run() {
                RequestContext ctx = RequestContext.getCurrentContext();
                HttpServletRequest request = ctx.getRequest();
                log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
                // 这里可以改变 request 的内容
                System.out.println("Here is Java filter!!!!");
                return null;
        }
}
