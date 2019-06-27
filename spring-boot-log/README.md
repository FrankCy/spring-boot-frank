# Spring Boot Log #

- application.yml

```yml
spring:
  application:
    name: spring-boot-log

server:
  port: 8081

# 配置日志级别，通过logging.level.《包路径》:《级别》设置
# 这里设置的是com.frank.sb.log包下的日志级别是debug
# 这里设置的是com.frank.sb.log.test包下的日志级别是info
logging:
  level:
    com:
      frank:
        sb:
          log: debug
            test:info
  pattern:
    console: "%date %-5level %logger{0} - %msg%n"
    file: "%date %-5level [%thread] %logger{0} [%file:%line] - %msg%n"
    level: "%5p"
  # 配置日志输出位置
  # Spring Boot 日志仅输出在控制台，不会写入日志文件。
  # 我们需要手动配置日志，使用file或者path属性（两者同级）
  # file:
  # 或者使用path
  path: ./logs/spring-boot-log
```

