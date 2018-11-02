package com.rjh.base;

import lombok.Data;

/**
 * 业务异常基类
 * @author RJH
 * <br/>Created in 2018-11-12
 */
@Data
public class BaseException extends Exception {

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
