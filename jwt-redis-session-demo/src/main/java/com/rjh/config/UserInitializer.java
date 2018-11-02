package com.rjh.config;

import com.rjh.entity.User;
import com.rjh.repository.UserRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author RJH
 * <br/>Created in 2018-11-02
 */
@Component
public class UserInitializer {

    @Resource
    private UserRepository userRepository;

    @PostConstruct
    public void initUser(){
        User user=new User();
        user.setUserName("admin");
        user.setPassword("admin");
        userRepository.save(user);
    }

}
