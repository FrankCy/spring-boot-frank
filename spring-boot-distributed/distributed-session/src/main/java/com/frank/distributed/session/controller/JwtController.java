package com.frank.distributed.session.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 *
 *
 * @author cy
 * @version JwtController.java, v 0.1 2021年02月08日 2:30 下午 cy Exp $
 */
@Slf4j
@RequestMapping("/jwt")
@RestController
public class JwtController {

    private static final String JWT_KEY = "frank";

    /**
     * 获取Token(从请求中获取)
     * @return
     */
    @GetMapping("/loginWithJwt")
    public String infoWithToken(@RequestParam String userName,
                                @RequestParam String password) {
        // 加密用的密钥
        Algorithm algorithm = Algorithm.HMAC256(JWT_KEY);

        String token = JWT.create()
                // 把登录人放入token
                .withClaim("login_user", userName)
                // 可以放入多个参数 1
                .withClaim("name", "")
                // 可以放入多个参数 2
                .withClaim("id", "")
                // 过期时间（6分钟，当前时间加3600秒 ）
                .withExpiresAt(new Date(System.currentTimeMillis() + 3600))
                .sign(algorithm);

        return token;
    }

    /**
     * 获取Token（从header中获取）
     * @param token
     * @return
     */
    @GetMapping("/infoWithJWT")
    public String infoWithTokenForHeader(@RequestHeader String token) {
        // 验证token
        Algorithm algorithm = Algorithm.HMAC256(JWT_KEY);
        JWTVerifier verifier = JWT.require(algorithm)
                .build();

        try {
            DecodedJWT jwt = verifier.verify(token);
            // 获取token中存储的key
            return jwt.getClaim("login_user").asString();
        } catch (TokenExpiredException e) {
            // 过期异常捕获
            log.error("过期异常捕获");
        } catch (JWTDecodeException jwtDecodeException) {
            // 解码失败（Token错误）
            log.error("解码失败（Token错误）");
        }

        return "error";

    }

    /**
     * 获取地址 token -> id
     * 拦截器统一处理Token
     * @param uid
     * @return
     */
    @GetMapping("/address")
    public Integer address(@RequestAttribute Integer uid) {
        return uid;
    }

}
