package com.rjh.controller;

import com.rjh.base.BaseException;
import com.rjh.base.BaseResponse;
import com.rjh.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * User的数据接口
 * @author RJH
 * <br/>Created in 2018-11-02
 */
@BaseResponse
@RestController
@RequestMapping(path = "users")
public class UserController {
    /**
     * 模拟存储数据库
     */
    private static Map<Integer, User> users=new ConcurrentHashMap<>();
    /**
     * 模拟自增ID
     */
    private static AtomicInteger currentId=new AtomicInteger(1);

    @GetMapping(path = "/{id}")
    public Object getUserById(@PathVariable("id") Integer id ){
        return users.get(id);
    }

    @PostMapping
    public Object saveUser(@RequestBody User user){
        user.setId(currentId.getAndIncrement());
        users.put(user.getId(),user);
        return user;
    }

    @PutMapping(path = "/{id}")
    public Object updateUser(@PathVariable("id") Integer id,@RequestBody User user) throws BaseException {
        if(users.containsKey(id)){
            user.setId(id);
            users.put(id,user);
            return user;
        }else{
            throw new BaseException("该用户不存在");
        }
    }

    @DeleteMapping(path = "/{id}")
    public Object deleteById(@PathVariable("id") Integer id){
        return users.remove(id);
    }

}
