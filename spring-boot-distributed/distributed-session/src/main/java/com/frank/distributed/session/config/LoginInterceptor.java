package com.frank.distributed.session.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * 拦截器（定义）
 *
 * @author cy
 * @version LoginInterceptor.java, v 0.1 2021年02月08日 3:07 下午 cy Exp $
 */
@Slf4j
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {


    private static final String JWT_KEY = "frank";

    private static final String JWT_TOKEN = "";

    private static final String UID = "id";

    /**
     * 返回true，表示不拦截（继续执行）
     * 返回false或异常，则被拦截（不继续执行）
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(JWT_TOKEN);
        if(StringUtils.isEmpty(token)) {
            throw new RuntimeException("Token为空");
        }

        Algorithm algorithm = Algorithm.HMAC256(JWT_KEY);
        JWTVerifier verifier = JWT.require(algorithm)
                .build();

        try {
            DecodedJWT jwt = verifier.verify(token);
            request.setAttribute(UID, jwt.getClaim(UID).asInt());
         } catch (TokenExpiredException e) {
            // 过期异常捕获
            throw new RuntimeException("过期异常捕获");
        } catch (JWTDecodeException jwtDecodeException) {
            // 解码失败（Token错误）
            throw new RuntimeException("解码失败（Token错误）");
        }

        return true;
    }
}
