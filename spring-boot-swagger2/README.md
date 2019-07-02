# Spring Boot Swagger2 #

## 前言 ##
在开发包含api的项目时，我们需要编写接口文档，spring boot的swagger2组件可以简单的生成这个web文档，以便减少编写markdwon或者word接口文档的时间，下面介绍下如何使用。

## Swagger2 ##
Swagger2提供了很多注解来实现这个文档生成的功能，下面先对注解进行简单对介绍。
### 注解介绍 ###
|注解|解释|
|:--|:--|
|@Api|修饰整个类，描述Controller的作用 |
|@ApiOperation|描述一个类的一个方法，或者说一个接口|
|@ApiParam|单个参数描述|
|@ApiModel|用对象来接收参数 |
|@ApiProperty|用对象接收参数时，描述对象的一个字段 |
|@ApiResponse|HTTP响应其中1个描述 |
|@ApiResponses|HTTP响应整体描述 |
|@ApiIgnore|使用该注解忽略这个API |
|@ApiError|发生错误返回的信息|
|@ApiImplicitParam|一个请求参数 |
|@ApiImplicitParams|多个请求参数|

## 示例 ##
### 导入依赖，采用2.8.0 ###
```xml
<dependencies>
    <!-- swagger2 核心依赖 begin -->
    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-swagger2</artifactId>
        <version>2.8.0</version>
    </dependency>
    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-swagger-ui</artifactId>
        <version>2.8.0</version>
    </dependency>
    <!-- swagger2 核心依赖 end -->
</dependencies>
```
### 编写Swagger2配置类 ###
**```此类要与启动类同级，请参照示例的目录结构编写。```**
```java
package com.frank.sb.swagger2;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 基础配置类
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 定义扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.frank.sb.swagger2"))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 构建 api文档的详细信息函数,注意这里的注解引用的是哪个
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("测试Swagger2")
                //描述
                .description("测试Swagger2文档")
                //创建人
                .contact(new Contact("frank", "", "cy880708@163.com"))
                //版本号
                .version("1.0")
                .build();
    }

}
```

### 为需要请求的API添加注解 ###
- 举例：为UserController提供的API添加注解
```java
package com.frank.sb.swagger2.controller;

import com.frank.sb.swagger2.entity.po.User;
import com.frank.sb.swagger2.entity.vo.UserVO;
import io.swagger.annotations.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户相关Controller
 */
@Api(value="/api/user", tags="用户相关接口")
@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    private static final Log logger = LogFactory.getLog(UserController.class);

    /**
     * 查询用户信息
     * @return
     */
    @ApiOperation(value="查询用户信息", notes = "根据用户主键，查询用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="userId", value="用户主键", required = true, dataType = "String"),
            @ApiImplicitParam(name="userName", value="用户名", required = false, dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "服务器异常"),
            @ApiResponse(code = 200, message = "服务器正常"),
            @ApiResponse(code = 404, message = "服务器请求地址异常"),
            @ApiResponse(code = 500, message = "服务器出错，无法使用")
    })
    @RequestMapping(value = "/findUserInfo", method = RequestMethod.POST)
    public User findUserInfo(UserVO userVO){

        logger.info("findUserInfo");
        User user = new User();
        user.setId("10086");
        user.setName("弗兰克");
        return user;
    }

}
```

**```注解含义，请参照上面的《注解介绍》```**


## 启动项目，查看效果 ##
[ 直接访问这个地址 http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## 总结 ##
这样，我们可以在编写API的同时，利用小部分时间，完成来未来需要大部分时间编写文档的工作。