package cn.rockystudio.gateway.assist;

/**
 * @author Rocky
 * @description 网关异常

* @Copyright 个人博客  www.rockyblog.top */
public class GatewayException extends RuntimeException {

    public GatewayException(String msg) {
        super(msg);
    }

    public GatewayException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
