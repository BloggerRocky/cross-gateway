package cn.rockystudio.gateway.core.session;

/**
 * @author Rocky
 * @description 网关会话工厂接口

* @Copyright 个人博客  www.rockyblog.top */
public interface GatewaySessionFactory {

    GatewaySession openSession(String uri);

}
