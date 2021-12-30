package com.wangyunqi.common.util;

import cn.hutool.core.util.StrUtil;


import java.io.Serializable;


public class Result<T> implements Serializable {

    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 返回编码
     */
    private int code;
    /**
     * 返回消息
     */
    private String message;
    /**
     * 返回数据
     */
    private T data;

    public Result() {
    }

    private Result(boolean success, String message, int code) {
        this.success = success;
        this.message = message;
        this.data = null;
        this.code = code;
    }

    public Result(boolean success, String message, T data, int code) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.code = code;
    }

    public static <T> Result<T> success() {
        return success(BaseCodeEnum.SUCCESS);
    }

    public static <T> Result<T> success(BaseCodeEnum codeEnum) {
        return success(codeEnum, null);
    }

    public static <T> Result<T> success(int code, String message) {
        return success(code, message, null);
    }

    public static <T> Result<T> success(String message) {
        return success(message, null);
    }

    public static <T> Result<T> success(T data) {
        return success(BaseCodeEnum.SUCCESS_NOTIP, data);
    }

    public static <T> Result<T> successOK() {
        return success(BaseCodeEnum.SUCCESS);
    }

    public static <T> Result<T> successOK(T data) {
        return success(BaseCodeEnum.SUCCESS, data);
    }

    public static <T> Result<T> success(BaseCodeEnum codeEnum, T data) {
        return new Result<T>(true, codeEnum.getMessage(), data, codeEnum.getCode());
    }

    public static <T> Result<T> success(String message, T data) {
        return new Result<T>(true, message, data, BaseCodeEnum.SUCCESS.getCode());
    }

    public static <T> Result<T> success(int code, String message, T data) {
        return new Result<T>(true, message, data, code);
    }

    public static <T> Result<T> failed() {
        return failed(BaseCodeEnum.FAILED);
    }

    public static <T> Result<T> failed(String message) {
        return failed(message, null);
    }

    public static <T> Result<T> failed(BaseCodeEnum codeEnum) {
        return failed(codeEnum, null);
    }

    public static <T> Result<T> failed(int code, String message) {
        return failed(code, message, null);
    }

    public static <T> Result<T> failed(BaseCodeEnum codeEnum, T data) {
        return new Result<T>(false, codeEnum.getMessage(), data, codeEnum.getCode());
    }

    public static <T> Result<T> failed(String message, T data) {
        return failed(BaseCodeEnum.FAILED.getCode(), message, data);
    }

    public static <T> Result<T> failed(int code, String message, T data) {
        return new Result<T>(false, message, data, code);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    /**
     * 安全的获取data数据，如果接口返回错误的，会抛出异常
     *
     * @return
     */
    public T getSafeData(String hintMsg) {
        if (!this.isSuccess()) {
            throw new BaseException(hintMsg + (StrUtil.isNotEmpty(this.message) ? "," + this.getMessage() : ""));
        }
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Result{" + "success=" + success + ", message='" + message + '\'' + ", data=" + data + ", code=" + code
                + '}';
    }
}
