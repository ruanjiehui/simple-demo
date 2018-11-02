package com.rjh.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

/**
 * 用户类
 * @author RJH
 * <br/>Created in 2018-11-02
 */
@Data
@RedisHash("User")
public class User implements Serializable {

    @Id
    private String userName;

    private String password;

}
