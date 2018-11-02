package com.rjh.base;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 注解切面处理器
 * @author RJH
 * <br/>Created in 2018-11-12
 */
@Aspect
@Component
@Slf4j
public class ResponseAspectDetector {

    @Around("@within(com.rjh.base.BaseResponse)")
    public Object handleResponse(ProceedingJoinPoint pjp){
        BaseResponseBody result=new BaseResponseBody();
        Object data=null;
        try{
            data=pjp.proceed();
            result.setStatus(true);//执行成功，修改标识
        }catch (Throwable e){
            log.error(e.getMessage(),e);
            if(e instanceof BaseException){//业务异常，获取错误信息填充
                //将异常的错误信息
                result.setErrorMsg(e.getMessage());
            }else{//无法识别的异常
                result.setErrorMsg("服务器出错，请稍后再试");
            }
        }finally {
            result.setData(data);
        }
        return result;
    }
}
