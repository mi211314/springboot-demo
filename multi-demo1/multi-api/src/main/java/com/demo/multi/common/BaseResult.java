package com.demo.multi.common;

import com.demo.multi.enums.ErrorCodeEnum;
import lombok.Data;

/**
 * @ClassName: BaseResult
 * @Description: BaseResult
 * @Date: 2019/4/22 16:45
 */
@Data
public class BaseResult<T> {

    /**
     * 响应码
     */
    public String code;

    /**
     * 响应信息
     */
    public String msg;

    /**
     * 业务数据
     */
    public T result;

    /**
     * 构建成功返回的resp
     * @return 返回对象
     */
    public static BaseResult buildSucBaseResult() {
        BaseResult br = new BaseResult();
        br.setCode(ErrorCodeEnum.ERROR_200.getCode());
        br.setMsg(ErrorCodeEnum.ERROR_200.getMessage());
        return br;
    }

    /**
     * 构建成功返回的resp（包含业务数据）
     * @param result 业务数据
     * @param <T> 业务数据类型
     * @return 返回对象
     */
    public static <T> BaseResult buildSucBaseResult(T result) {
        BaseResult br = new BaseResult();
        br.setCode(ErrorCodeEnum.ERROR_200.getCode());
        br.setMsg(ErrorCodeEnum.ERROR_200.getMessage());
        br.setResult(result);
        return br;
    }

    /**
     * 构建失败返回的resp
     * @return 返回对象
     */
    public static BaseResult buildFailBaseResult() {
        BaseResult br = new BaseResult();
        br.setCode(ErrorCodeEnum.ERROR_400.getCode());
        br.setMsg(ErrorCodeEnum.ERROR_400.getMessage());
        return br;
    }

    /**
     * 构建失败返回的resp(根据响应码)
     * @param code 响应码
     * @return 返回对象
     */
    public static BaseResult buildFailBaseResult(String code) {
        BaseResult br = new BaseResult();
        br.setCode(code);
        br.setMsg(ErrorCodeEnum.getMessageByCode(code));
        return br;
    }

    /**
     * 构建失败返回的resp(根据响应码、响应信息)
     * @param code 响应码
     * @param msg 响应信息
     * @return 返回对象
     */
    public static BaseResult buildFailBaseResult(String code, String msg) {
        BaseResult br = new BaseResult();
        br.setCode(code);
        br.setMsg(msg);
        return br;
    }

}
