package com.springboot.test.apidocs;

import com.fasterxml.classmate.TypeResolver;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Date;

/**
 * Created by Jerry on 16/8/23.
 */
@Configuration @EnableSwagger2 @ComponentScan("com.springboot.test.controller") @AutoConfigureAfter(
        WebMvcAutoConfiguration.class) public class WebApiAutoConfiguration extends WebMvcConfigurerAdapter {
        protected Logger logger = org.slf4j.LoggerFactory.getLogger(WebApiAutoConfiguration.class);

        @Value("${springfox.api.group:[your group name]}") private String apiGroupName;

        @Value("${springfox.api.title:[set a api title]}") private String title;

        @Value("${springfox.api.desc:[set a api desc via springfox.api.desc]}") private String desc;

        @Value("${springfox.api.version:[set a api version]}") private String version;

        @Value("${springfox.api.termsOfServiceUrl:[set a api title]}") private String termsOfServiceUrl;

        @Value("${springfox.api.contact:[set a api title]}") private String contact;

        @Value("${springfox.api.license:[set a api title]}") private String license;

        @Value("${springfox.api.licenseUrl:[set a api title]}") private String licenseUrl;

        @Autowired private TypeResolver typeResolver;

        @Bean public Docket api() {

                ApiInfo apiInfo = new ApiInfo(title, desc, version, termsOfServiceUrl, contact, license, licenseUrl);
                return new Docket(DocumentationType.SWAGGER_2).groupName(apiGroupName).apiInfo(apiInfo).select()
                        .apis(RequestHandlerSelectors.basePackage("com.springboot.test.controller")).paths(PathSelectors.any()).build().pathMapping("/")
                        .directModelSubstitute(Date.class, String.class).genericModelSubstitutes(ResponseEntity.class);
        }

}
