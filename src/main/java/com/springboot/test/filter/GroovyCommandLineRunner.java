package com.springboot.test.filter;

import com.netflix.zuul.FilterFileManager;
import com.netflix.zuul.FilterLoader;
import com.netflix.zuul.groovy.GroovyCompiler;
import com.netflix.zuul.groovy.GroovyFileFilter;
import com.netflix.zuul.monitoring.MonitoringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by Jerry on 2016/10/31.
 */
@Component
public class GroovyCommandLineRunner implements CommandLineRunner {

        private static Logger log = LoggerFactory.getLogger(GroovyCommandLineRunner.class);

        @Value("${zuul.groovy.path}")
        private String groovyPath;
        @Override
        public void run(String... args) throws Exception {
                MonitoringHelper.initMocks();
                FilterLoader.getInstance().setCompiler(new GroovyCompiler());

                try {
                        // 此处可以根据需求灵活处理，比如从一个 server 加载 groovy 文件
                        FilterFileManager.setFilenameFilter(new GroovyFileFilter());
                        FilterFileManager.init(10, groovyPath);
                } catch (Exception e) {
                        log.error(e.getMessage(), e);
                }
        }
}
