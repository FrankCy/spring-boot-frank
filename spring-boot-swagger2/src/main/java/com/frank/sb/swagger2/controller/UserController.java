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
