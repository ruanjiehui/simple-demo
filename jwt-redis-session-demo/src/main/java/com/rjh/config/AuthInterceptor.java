package com.rjh.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.rjh.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author RJH
 * <br/>Created in 2018-11-02
 */
@Component
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    @Resource
    private UserRepository userRepository;

    @Value("${jwt.secret}")
    private String secret;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getMethod().equals(HttpMethod.HEAD) || request.getMethod().equals(HttpMethod.OPTIONS)){
            return true;
        }
        String token=request.getHeader("Auth");
        try{
            DecodedJWT jwt=JWT.require(Algorithm.HMAC256(secret.getBytes())).build().verify(token);
            return true;
        }catch (Exception e){
            log.error(e.getMessage(),e);
        }
        return false;
    }
}
