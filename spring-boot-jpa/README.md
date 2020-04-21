# Spring Boot JPA
- - - 
JPA Demo【实现新增和查询】

## 步骤 1
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
## 步骤 2
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
## 步骤 3
实现实体 User.java

## 步骤 4
编写接口（repository）继承JpaRepository<Entity, Integer>
通过继承JpaRepository实现CRUD
UserRepository.java

## 步骤 5
实现Service和ServiceImpl
UserService.java
UserServiceImpl.java
## 步骤6
编写Controller
UserController.java
### 地址
- 新增
http://localhost:8080/user/saveUser
- 查询
http://localhost:8080/user/getUser

- - -
使用JPA，编写实体之后启动就可以将表和字段生成在yaml配置中对应的数据库中