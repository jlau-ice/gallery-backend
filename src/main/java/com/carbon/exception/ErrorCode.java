package com.carbon.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    SUCCESS(0, "ok"),
    PARAMS_ERROR(40000, "请求参数错误"),
    NO_LOGIN_ERROR(40100, "未登录"),
    NOT_AUTH_ERROR(40101, "无授权"),
    NOT_FOUND_ERROR(40400, "请求参数不存在"),
    FORBIDDEN_ERROR(40300, "禁止访问"),
    SYSTEM_ERROR(50000, "系统内部异常"),
    OPERATION_ERROR(50001, "操作失败");

    /**
     * 状态码
     */
    private final int code;

    /**
     * 信息
     */
    private final String message;

    /**
     * 构造方法
     * @param code 错误码
     * @param message 响应信息
     */
    ErrorCode(int code, String message) {
        this.code = code;
        this.message =message;
    }
}