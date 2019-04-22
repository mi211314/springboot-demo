package com.demo.multi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 返回错误码枚举
 */
@AllArgsConstructor
@Getter
public enum ErrorCodeEnum {

	ERROR_200("200", "成功"),
	ERROR_400("400", "失败");

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误信息
     */
    private String message;

    /**
     * 根据code获取message
     * @param code
     * @return
     */
    public static String getMessageByCode(String code) {
        for (ErrorCodeEnum c : ErrorCodeEnum.values()) {
            if (c.getCode().equalsIgnoreCase(code)) {
                return c.message;
            }
        }
        return "";
    }

    /**
     * 根据message获取code
     * @param message
     * @return
     */
    public static String getCodeByMessage(String message) {
        for (ErrorCodeEnum c : ErrorCodeEnum.values()) {
            if (c.getMessage().equalsIgnoreCase(message)) {
                return c.code;
            }
        }
        return "";
    }

}
