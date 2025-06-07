package cn.rockystudio.gateway.core.datasource;

/**
 * @author Rocky
 * @description 连接接口

* @Copyright 个人博客  www.rockyblog.top */
public interface Connection {

    Object execute(String method, String[] parameterTypes, String[] parameterNames, Object[] args);

}
