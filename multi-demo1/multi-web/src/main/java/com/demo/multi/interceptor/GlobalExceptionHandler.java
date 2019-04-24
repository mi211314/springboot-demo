package com.demo.multi.interceptor;

import com.demo.multi.common.BaseResult;
import com.demo.multi.enums.ErrorCodeEnum;
import com.demo.multi.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description: 全局异常处理拦截器
 * @Date: 2018/12/29 9:59
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 全局异常处理
     * @param e 异常对象
     * @return 返回数据
     * @date 2018/12/29 13:54
     */
    @ExceptionHandler(Exception.class)
    public BaseResult exceptionHandle(Exception e) {
        if (e instanceof BusinessException) {
            BusinessException exception = (BusinessException) e;
            return BaseResult.buildFailBaseResult(exception.getCode(), exception.getMessage());
        } else {
            /*log.error(ErrorCodeEnum.ERROR_400.getMessage(), e);*/
            return BaseResult.buildFailBaseResult(ErrorCodeEnum.ERROR_400.getCode());
        }
    }

}
