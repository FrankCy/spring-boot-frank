# Spring Boot Actuator #

## 前言 ##
是Spring Boot 一个非常强大功能，可以对应用程序进行监视和管理，通过```restful api```请求来监管、审计、收集应用的运行情况，针对微服务而言它是必不可少的一个组件。

## 组成部分 ##
### Endpoints ###
actuator核心部分，用来监视应用程序及交互，```spring-boot-actuator```中已经内置非常多的```Endpoints(health、info、beans、httptrace、shutdown等等),```同时，也允许程序员自定义扩展端点.

**```Spring Boot 2.0```** 中的端点相较之前版本有较大不同，使用时需注意。另外端点的监控机制也有很大的不同，启用了不代表可以直接访问，还需要将其暴露出来，传统的```management.security```管理已被标记为不推荐。

### 内置Endpoints ###
|id|desc|Sensitive |
|:--|:--|:--|
|auditevents| 显示当前应用程序的审计事件信息 | Yes |
|beans| 显示应用Spring Beans的完整列表 | Yes |
|caches| 显示可用缓存信息 | Yes |
|conditions| 显示自动装配类的状态及及应用信息 | Yes |
|configprops| 显示所有 @ConfigurationProperties 列表 | Yes |
|env| 显示 ConfigurableEnvironment 中的属性 | Yes |
|flyway| 显示 Flyway 数据库迁移信息 | Yes |
|health| 显示应用的健康信息（未认证只显示status，认证显示全部信息详情） | No |
|info| 显示任意的应用信息（在资源文件写info.xxx即可） | No |
|liquibase| 展示Liquibase 数据库迁移 | Yes |
|metrics| 展示当前应用的 metrics 信息 | Yes |
|mappings| 显示所有 @RequestMapping 路径集列表 | Yes |
|scheduledtasks| 显示应用程序中的计划任务 | Yes |
|sessions| 允许从Spring会话支持的会话存储中检索和删除用户会话 | Yes |
|shutdown| 允许应用以优雅的方式关闭（默认情况下不启用） | Yes |
|threaddump| 执行一个线程dump | Yes |
|httptrace| 显示HTTP跟踪信息（默认显示最后100个HTTP请求 - 响应交换） | Yes |

## 配置 ##
### 配置pom.xml ###
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
### 如果要访问info接口想获取maven中的属性内容请记得添加如下内容 ###
```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <executions>
                <execution>
                    <goals>
                        <goal>build-info</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```

## yml配置actuator ##
yml中配置actuator，其中info开头的属性，就是访问info端点中显示的相关内容，值得注意的是Spring Boot2.x中，默认只开放了info、health两个端点，其余需要自己通过配置```management.endpoints.web.exposure.include```属性来加载（包含include 自然就有 exclue，等其它属性）。```如果想单独操作某个端点，可使用management.endpoint.端点.enabled属性进行启用或禁用。```

```yml
# 描述信息
info:
  blog-url: http://winterchen.com
  author: Luis
  # 能获取到maven中配置的版本信息
  version: @project.version@

# 加载所有的端点/默认只加载了 info/health
management:
  endpoints:
    web:
      exposure:
        include: *
  endpoint:
    health:
      show-details: always
    # 关闭指定的端点
    shutdown:
      enabled: false
#    # 路径映射，将health路径映射成rest_health，那么在访问health路径将为404，因为原请求地址"health"已变成"rest_health"，通常不建议使用此功能：
#    web:
#      path-mapping:
#        health: rest_health

```