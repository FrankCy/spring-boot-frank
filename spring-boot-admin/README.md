# Spring Boot Admin 监控 #
## 前言 ##
通过Spring Boot Admin 对系统进行监控，可以同时监控多个客户端。

**```分为至少两个端（server & client），server作为监控主进程，client作为加入监控主进程的客户端，需要一个admin server，然后再admin client（客户端）的yml总配置即可。```**

## 一图简介 ##
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190808180001567.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9mcmFua3lvdW5nLmJsb2cuY3Nkbi5uZXQ=,size_16,color_FFFFFF,t_70)
- 如上图所示，服务器监控系统同时对PC、ADMIN、APP进行监控，在监控系统中（server端），即可以看到这些对应的客户端运行情况。
## Spring Boot 集成 Spring Boot Admin ##
```创建spring boot项目，版本使用2.1+ 如下：```
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>spring-boot-admin</groupId>
    <artifactId>spring-boot-admin</artifactId>
    <packaging>pom</packaging>
    <version>1.0-SNAPSHOT</version>
    <modules>
        <module>spring-boot-admin-client</module>
        <module>spring-boot-admin-servers</module>
    </modules>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.1.0.RELEASE</version>
        <relativePath/>
    </parent>

    <properties>
        <java.version>1.8</java.version>
    </properties>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>
```
### Spring Boot Admin Server ###
```Admin Server作为服务器监控的程序，类似于一个服务提供者，其他客户端要与之建立关系（其实不该这么不专业的作为解释，为了方便理解，这里我就这么记载了）```
#### pom.xml ####
```xml
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>de.codecentric</groupId>
            <artifactId>spring-boot-admin-starter-server</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>de.codecentric</groupId>
                <artifactId>spring-boot-admin-dependencies</artifactId>
                <version>2.1.3</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
```

#### 应用启动程序 ####
```java
@SpringBootApplication
@EnableAdminServer
public class AdminServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminServerApplication.class, args);
    }
}
```
#### yml ####
```yml
spring:
  application:
    name: spring-boot-admin-server
server:
  port: 8769
```
### Spring Boot Admin Client ###
```同样是Spring Boot项目，版本也要相一致```
#### pom.xml ####
```xml
	<dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>de.codecentric</groupId>
            <artifactId>spring-boot-admin-starter-client</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>de.codecentric</groupId>
                <artifactId>spring-boot-admin-dependencies</artifactId>
                <version>2.1.3</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
```
#### 应用启动程序 ####
```常规启动类```
```java
@SpringBootApplication
public class AdminClientApplication {
    public static void main(String[] args) {
        SpringApplication.run( AdminClientApplication.class, args );
    }
}
```
#### yml ####
```yml
spring:
  application:
    name: spring-bootadmin-client
  boot:
    admin:
      client:
        # 要注册的Spring Boot Admin Server的URL
        url: http://localhost:8769
server:
  port: 8768

# 与Spring Boot 2一样，默认情况下，大多数actuator的端口都不会通过http公开，* 代表公开所有这些端点。对于生产环境，应该仔细选择要公开的端点。
management:
  endpoints:
    web:
      exposure:
        include: '*'
  endpoint:
    health:
      show-details: ALWAYS
```
### admin控制台 ###
**```按照上面的配置，我们的Admin监控就可以使用了。```**
访问地址：[http://localhost:8769](http://localhost:8769)
系统自动跳转到：[http://localhost:8769/#/applications](http://localhost:8769/#/applications)
```这个例子我们并没有配置 Security来作服务器端鉴权。 ```
#### applications ####
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190808183543681.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9mcmFua3lvdW5nLmJsb2cuY3Nkbi5uZXQ=,size_16,color_FFFFFF,t_70)

#### Wallboard ####
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190808183620997.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9mcmFua3lvdW5nLmJsb2cuY3Nkbi5uZXQ=,size_16,color_FFFFFF,t_70)
进入之后：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190808183642148.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9mcmFua3lvdW5nLmJsb2cuY3Nkbi5uZXQ=,size_16,color_FFFFFF,t_70)
## 注意 ##
**```因为使用的 Spring Boot Admin的版本是2.1+，所以Spring Boot也要使用2.1+以上版本，否则无法启动admin server。```**