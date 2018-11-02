package com.rjh.base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 公共响应体注解<br/>
 * 方法返回值需要为Object
 * @author RJH
 * <br/>Created in 2018-11-12
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface BaseResponse {

}
