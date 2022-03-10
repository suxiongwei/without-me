package com.sxw.learn.auth;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description 状态码枚举
 * @Date 2020-05-04 4:37 下午
 */
public enum ResultCode {
    //-----------------1xxxx 系统正常----------------
    SUCCESS(1, "成功"),

    ZHUBO_TARGET_NOT_EXIST(10001, "本月目标暂未制定，请耐心等待..."),

    //-----------------2xxxx 系统错误----------------
    PARAMS_ERROR(20001, "参数错误，请参考API文档"),
    MD5_SIGN_ERROR(20002, "MD5签名失败"),
    SYSTEM_ERROR(20003, "系统异常"),
    JSON_PARSE_ERROR(20004,"Json解析错误"),
    NO_UNAUTHORIZED(20005, "权限不足"),
    REQUEST_TIMED_OUT(20006, "请求超时"),
    NO_UNAUTHORIZED_FROM(20007, "未授权的调用来源"),





    TYPE_NOT_EXPECTED(30001, "type not support"),
    NOT_ORDER(30002, "没有符合条件的订单数据"),


    EXPORT_COUNT_TOO_BIG(30002, "文件导出条数太多，请限制条数在100000以下"),
    CANT_GET_ADID(30003, "请求头中无法根据Authorization判断出adid"),
    TELL_YUNYING_EXCEPTION(30004, "通知运营后台待下载文件地址时发生异常"),

    CATCH_EXCEPTION(0, "捕捉到异常"),

    ;

    /**
     * 错误号
     */
    public final int code;
    /**
     * 错误描述
     */
    public final String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
