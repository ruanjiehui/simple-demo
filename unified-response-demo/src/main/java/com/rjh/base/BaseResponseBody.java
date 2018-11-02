package com.rjh.base;

import lombok.Data;

import java.io.Serializable;

/**
 * 公共响应实体
 * @author RJH
 * <br/>Created in 2018-11-12
 */
@Data
public class BaseResponseBody implements Serializable {
    /**
     * 实际响应的数据
     */
    private Object data;
    /**
     * 成功处理标识
     */
    private boolean status;
    /**
     * 错误信息
     */
    private String errorMsg;

}
