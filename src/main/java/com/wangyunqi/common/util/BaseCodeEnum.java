package com.wangyunqi.common.util;

/**
 * 基础通用枚举
 */
public enum BaseCodeEnum {
    /**
     * 操作成功
     */
    SUCCESS(200, "操作成功"),

    SUCCESS_NOTIP(200, ""),

    UNAUTHORIZED(401, "未登录认证"),

    /**
     * 操作失败
     */
    FAILED(500, "操作失败"),

    /**
     * 动态Code
     */
    CODE(-1, "");

    /**
     * 响应码
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String message;

    BaseCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    /**
     * 自定义枚举code,message 注意:只能使用 BaseCodeEnum.CODE BaseCodeEnum.CODE.set(int
     * code,String message)
     *
     * @param code    code
     * @param message message
     * @return BaseCodeEnum
     */
    public BaseCodeEnum set(int code, String message) {
        this.code = code;
        this.message = message;
        return this;
    }

    /**
     * 变更指定枚举 message 任意枚举都可以使用 BaseCodeEnum.CODE.set(String message)
     *
     * @param message message
     * @return ResultCodeEnum
     */
    public BaseCodeEnum set(String message) {
        BaseCodeEnum.CODE.set(this.getCode(), message);
        return BaseCodeEnum.CODE;
    }
}
