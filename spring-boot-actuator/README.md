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
        include: "*"“
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

- 启动项目，并访问 http://localhost:8082/actuator/info
```json
{"blog-url":"http://winterchen.com","author":"Luis","version":"1.0-SNAPSHOT"}
```

## 自定义Actuator（学习重点） ##
以上是默认的以及自带的配置，实际应用中有时候默认并不能满足我们的要求，比如Spring Boot默认的的配置并不能满足实际应用需求。

- 默认装配 HealthIndicators
下列是依赖```spring-boot-xxx-starter```后相关HealthIndicator的实现（通过```maangement.health.defaults.enabled```属性可以禁用它们），但想要获取一些特定的，例如监控某个特定业务是否可用时，就需要自定义HealthIndicator了

|属性|描述|
|:--|:--|
|CassandraHealthIndicator|检查Cassandra数据库是否启动|
|DiskSpaceHealthIndicator|检查磁盘空间不足|
|DataSourceHealthIndicator|检查是否可以获得连接DataSource|
|ElasticsearchHealthIndicator|检查Elasticsearch集群是否启动|
|InfluxDbHealthIndicator|检查InfluxDB服务器是否启动|
|JmsHealthIndicator|检查JMS代理是否启动|
|MailHealthIndicator|检查邮件服务器是否启动|
|MongoHealthIndicator|检查Mongo数据库是否启动|
|Neo4jHealthIndicator|检查Neo4j服务器是否启动|
|RabbitHealthIndicator|检查Rabbit服务器是否启动|
|RedisHealthIndicator|检查Redis服务器是否启动|
|SolrHealthIndicator|检查Solr服务器是否启动|

### 示例1：健康端点 ###
***要求：实现```HealthIndicator```接口，自定义检测内容，并返回状态```UP```还是```DOWN```，来尝试一下吧。***
```java
package com.frank.sb.actuator.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component("frankHealthIndicator_1")
public class MyHealthIndicator implements HealthIndicator {

    private static final String VERSION = "V1.0.0";

    /**
     * 自定义检测check函数内容是否为0的例子。
     * 我们可以访问
     * @return
     */
    @Override
    public Health health() {
        // 获取自定义check内容
        int code = check();
        // 当check不等于0时，DOWN：代表运行错误
        if(code != 0) {
            Health.down().withDetail("code", code).withDetail("version", VERSION).build();
        }
        // 当check结果为0时，UP：代表运行正常
        return  Health.up().withDetail("code", code).withDetail("version", VERSION).up().build();
    }

    private int check() {
        return 0;
    }
}

```

- 访问查看结果

[http://localhost:8082/actuator/health](http://localhost:8082/actuator/health)

```json
{
    "status":"UP", 
    "details":{
        "frank":{
            "status":"UP", "details":{
                "code":0, "version":"V1.0.0"
            }
        },"diskSpace":{
            "status":"UP", "details":{
                "total":536870907904, "free":349543550976, "threshold":10485760
            }
        }
    }
}
```

### 示例2：健康断点 ###
继承```AbstractHealthIndicator```抽象类，重写```doHealthCheck```方法，功能比示例1更强大，默认```DataSourceHealthIndicator、RedisHealthIndicator```都是这种写法，内容回调中还做了异常处理。
代码示例如下：
```java
package com.frank.sb.actuator.config;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

/**
 * 自定义健康端点
 * 功能强大一些。
 * DataSourceHealthIndicator 与 RedisHealthIndicator 写法相同
 */
@Component("frankHealthIndicator_2")
public class MyAbstractHealthIndicator extends AbstractHealthIndicator {
    
    private static final String VERSION = "V1.0.0";
    
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        int code = check();
        if(code != 0) {
            builder.down().withDetail("code", code).withDetail("version", VERSION).build();
        }
        builder.withDetail("code", code).withDetail("version", VERSION).up().build();
    }
    
    private int check() {
        return 0;
    }
}

```

- 访问查看结果

[http://localhost:8082/actuator/health](http://localhost:8082/actuator/health)

```json
{
    "status":"UP", 
    "details":{
        "frank":{
            "status":"UP", "details":{
                "code":0, "version":"V1.0.0"
            }
        },"diskSpace":{
            "status":"UP", "details":{
                "total":536870907904, "free":349540884480, "threshold":10485760
            }
        }
    }
}
```

**```如果能访问到，并显示上面信息，代表配置成功。```**

### 自定义端点 ###


