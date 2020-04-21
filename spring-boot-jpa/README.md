# Spring Boot JPA

- - - 
JPA Demo【实现新增和查询】

## 1. 配置依赖
配置依赖
```xml
<dependencies>
        <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
            <version>2.2.6.RELEASE</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-jdbc -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jdbc</artifactId>
            <version>2.2.6.RELEASE</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <version>2.2.6.RELEASE</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.19</version>
        </dependency>

    </dependencies>
```
## 2. 配置yaml
配置yaml
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/springbootjpa?serverTimezone=GMT
    username: root
    password: root
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    hibernate:
      ddl-auto: update    #更新或者创建表
    show-sql: true        #控制台显示sql
```
## 3. 实现实体
实现实体 User.java

## 4. 编写接口（repository）
编写接口（repository）继承JpaRepository<Entity, Integer>
通过继承JpaRepository实现CRUD
UserRepository.java

## 5. 实现Service和ServiceImpl
实现Service和ServiceImpl
UserService.java
UserServiceImpl.java
## 6. 编写Controller
编写Controller
UserController.java
### 地址
- 新增
http://localhost:8080/user/saveUser
- 查询
http://localhost:8080/user/getUser

- - -
使用JPA，编写实体之后启动就可以将表和字段生成在yaml配置中对应的数据库中；

## GitHub地址
[https://github.com/FrankCy/spring-boot-frank/tree/master/spring-boot-jpa](https://github.com/FrankCy/spring-boot-frank/tree/master/spring-boot-jpa)