#仅供练习 SpringBoot 用

##基于 spring boot 

###依赖
mysql
rabbitmq
eureka-server(https://github.com/jcs7575/eureka)
spring-config-server(https://github.com/jcs7575/spring-config-server)

###隐式拦截返回结果进行处理
详见「WebApiConfiguration」

###数据库连接池使用 Druid
详见「DruidConfig、DatabaseConfiguration」,加入了连接池监控功能
监控 [url](http://127.0.0.1:8080/druid/index.html) username/password=admin/admin

###添加 Swagger 支持生成 api-doc
详见 WebApiAutoConfiguration 
URL [api-docs](http://127.0.0.1:8080/swagger-ui.html)

###添加 Eureka 处理服务注册发现
Eureka server 请参照「eureka」项目，直接 fork 了一个运行 server
也可以直接下载 eureka 的 war 包运行

###添加 Actuator 负责服务状态监控
可以很方便的监控一些服务状态，需要自定义可以通过 EndPoint 机制实现

###添加 Spring-Bus 用来在线更新集群的配置
通过 /bus/refresh 刷新服务，集群中标注了 @RefreshScope 的服务都会被刷新，无需刷新每一台服务

###添加 Robbin LoadBalance
参考[BeanConfig.RestTemplate](https://github.com/jcs7575/springbootdemo/tree/master/src/main/java/com/springboot/test/core/BeanConfig.java)

###添加 Feign 简化服务间调用
参考[DemoService](https://github.com/jcs7575/springbootdemo/tree/master/src/main/java/com/springboot/test/service/DemoService.java)

###添加 Hystrix 断路器
参考[HystrixServiceImpl](https://github.com/jcs7575/springbootdemo/tree/master/src/main/java/com/springboot/test/service/HystrixServiceImpl.java)

###添加 Zuul 组件
参考[filter](https://github.com/jcs7575/springbootdemo/tree/master/src/main/java/com/springboot/test/filter)目录
这里需要注意的是在 application.yml 文件中要自定义 zuul.servletPath,默认是 「zuul」<br/>
api 是通过请求的时候指定 servletPath 才生效，例如定义的 api 是「/filter/pre」那么如果想要 zuul 生效，则请求的api 是「/servletPath/filter/pre」<br/>
groovy 动态加载 filter 请参考[GroovyCommandLineRunner](https://github.com/jcs7575/springbootdemo/tree/master/src/main/java/com/springboot/test/filter/GroovyCommandLineRunner.java)
