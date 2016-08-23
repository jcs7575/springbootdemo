#仅供练习 SpringBoot 用

##基于 spring boot 

###隐式拦截返回结果进行处理
详见「WebApiConfiguration」
###数据库连接池使用 Druid
详见「DruidConfig、DatabaseConfiguration」,加入了连接池监控功能

监控 [url](http://127.0.0.1:8080/druid/index.html) username/password=admin/admin
###添加 Swagger 支持生成 api-doc
详见 WebApiAutoConfiguration 

URL [api-docs](http://127.0.0.1:8080/swagger-ui.html) 

