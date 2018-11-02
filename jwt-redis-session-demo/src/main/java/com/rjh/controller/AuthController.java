package com.rjh.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.rjh.entity.User;
import com.rjh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author RJH
 * <br/>Created in 2018-11-02
 */
@RestController
public class AuthController {

    @Resource
    private UserRepository userRepository;

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.issuer}")
    private String issuer;

    @PostMapping
    public void login(@RequestBody User user, HttpServletResponse response){
        List<User> users=userRepository.findByUserNameAndPassword(user.getUserName(),user.getPassword());
        String token=null;
        if(!CollectionUtils.isEmpty(users)){
            User loginUser=users.get(0);
            //生效时间
            Date issueTime=new Date();
            Calendar now= Calendar.getInstance();
            now.add(Calendar.SECOND,2*60*60);
            //过期时间
            Date expireTime=now.getTime();
            token= JWT.create().withIssuer(issuer).withSubject(loginUser.getUserName()).withIssuedAt(issueTime).withExpiresAt(expireTime).sign(Algorithm.HMAC256(secret.getBytes()));
            response.setHeader("Auth",token);
        }
    }

}
