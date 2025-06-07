package cn.rockystudio.gateway.assist.common;

/**
 * @author Rocky
 * @description 统一返回对象中，Code码、Info描述

* @Copyright 个人博客  www.rockyblog.top */
public class Result<T> {

    private String code;
    private String info;
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
