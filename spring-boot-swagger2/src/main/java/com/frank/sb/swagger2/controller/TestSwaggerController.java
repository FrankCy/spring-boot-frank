package com.frank.sb.swagger2.controller;

import com.frank.sb.swagger2.entity.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

/**
 * @Api：用在请求的类上，表示对类的说明
tags="说明该类的作用，可以在UI界面上看到的注解"
value="该参数没什么意义，在UI界面上也看到，所以不需要配置"
 *
 */
@Api(value="/test1", tags="测试接口模块")
@RestController
@RequestMapping("/test")
public class TestSwaggerController {

    /**
     * @ApiOperation：用在请求的方法上，说明方法的用途、作用
    value="说明方法的用途、作用"
    notes="方法的备注说明"
     @ApiImplicitParams：用在请求的方法上，表示一组参数说明
     @ApiImplicitParam：用在@ApiImplicitParams注解中，指定一个请求参数的各个方面
     name：参数名
     value：参数的汉字说明、解释
     required：参数是否必须传
     paramType：参数放在哪个地方
     · header --> 请求参数的获取：@RequestHeader
     · query --> 请求参数的获取：@RequestParam
     · path（用于restful接口）--> 请求参数的获取：@PathVariable
     · body（不常用）
     · form（不常用）
     dataType：参数类型，默认String，其它值dataType="Integer"
     defaultValue：参数的默认值

     @ApiResponses：用在请求的方法上，表示一组响应
     @ApiResponse：用在@ApiResponses中，一般用于表达一个错误的响应信息
     code：数字，例如400
     message：信息，例如"请求参数没填好"
     response：抛出异常的类

     @ApiModel：用于响应类上，表示一个返回响应数据的信息
     （这种一般用在post创建的时候，使用@RequestBody这样的场景，
     请求参数无法使用@ApiImplicitParam注解进行描述的时候）
     @ApiModelProperty：用在属性上，描述响应类的属性
      * @return
     */
    @ApiOperation(value="展示首页信息value", notes = "展示首页信息notes")
    @GetMapping("/show")
    public Object showInfo(){
        return "hello world";
    }

    @ApiOperation(value="添加用户信息", notes = "添加用户信息")
    @ApiImplicitParam(name="user", value="User", required = true, dataType = "User")
    @PostMapping("/addUser")
    public Object addUser(@RequestBody User user){
        return "success";
    }

    @ApiOperation(value="查询用户信息", notes = "查询用户基本信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id", value="用户主键信息", required = true, dataType = "java.lang.String"),
            @ApiImplicitParam(name="name", value="用户昵称", required = true, dataType = "java.lang.String")
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "服务器异常"),
            @ApiResponse(code = 200, message = "服务器正常"),
            @ApiResponse(code = 404, message = "服务器请求地址异常"),
            @ApiResponse(code = 500, message = "服务器出错，无法使用")
    })
    @RequestMapping(value = "/findUser", method = RequestMethod.POST)
    public Object findUser(String id, String name){
        return "success";
    }

}