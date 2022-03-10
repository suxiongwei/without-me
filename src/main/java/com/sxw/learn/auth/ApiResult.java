package com.sxw.learn.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2020-05-04 4:39 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResult {
    private Integer code;
    private String msg;
    private Object data;

    public ApiResult(ResultCode resultCode) {
        this.code = resultCode.code;
        this.msg = resultCode.msg;
        this.data = "";
    }

    public ApiResult(ResultCode resultCode, Object data) {
        this.code = resultCode.code;
        this.msg = resultCode.msg;
        this.data = data;
    }

    public static ApiResult success() {
        return new ApiResult(ResultCode.SUCCESS);
    }

    public static ApiResult success(Object data) {
        return new ApiResult(ResultCode.SUCCESS, data);
    }

    public static ApiResult failure(ResultCode resultCode) {
        return new ApiResult(resultCode);
    }

    public static ApiResult failure(ResultCode resultCode, Object data) {
        return new ApiResult(resultCode, data);
    }
}
