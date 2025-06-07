package cn.rockystudio.gateway.core.executor.result;

/**
 * @author Rocky
 * @description 会话结果封装

* @Copyright 个人博客  www.rockyblog.top */
public class SessionResult {

    private String code;
    private String info;
    private Object data;

    protected SessionResult(String code, String info, Object data) {
        this.code = code;
        this.info = info;
        this.data = data;
    }

    public static SessionResult buildSuccess(Object data) {
        return new SessionResult("0000", "调用成功", data);
    }

    public static SessionResult buildError(Object data) {
        return new SessionResult("0001", "调用失败", data);
    }

    public String getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }

    public Object getData() {
        return data;
    }

}
