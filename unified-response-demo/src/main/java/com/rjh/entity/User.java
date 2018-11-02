package com.rjh.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户类
 * @author RJH
 * <br/>Created in 2018-11-02
 */
@Data
public class User implements Serializable {

    private Integer id;

    private String name;

}
