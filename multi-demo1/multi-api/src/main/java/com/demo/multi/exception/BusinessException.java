package com.demo.multi.exception;

import lombok.Data;

/**
 * @ClassName: BusinessException
 * @Description: BusinessException
 * @Date: 2019/4/22 16:20
 */
@Data
public class BusinessException extends RuntimeException {

    /**
     * 异常代码
     */
    private String code;

    public BusinessException() {

    }

    public BusinessException(String code) {
        this.code = code;
    }

    public BusinessException(String message, String code) {
        super(message);
        this.code = code;
    }

}
