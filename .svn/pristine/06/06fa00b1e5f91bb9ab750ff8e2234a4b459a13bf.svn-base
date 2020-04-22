package com.cn.exception;

/**
 * jwt相关的异常
 * @author:Teacher黄
 * @date:Created at 2019/11/25
 */
public class JwtException extends Exception {

    private Integer code;

    private String msg;

    public JwtException() {
    }

    public JwtException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
