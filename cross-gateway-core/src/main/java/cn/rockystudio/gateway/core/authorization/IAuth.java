package cn.rockystudio.gateway.core.authorization;

/**
 * @author Rocky
 * @description 认证服务接口

* @Copyright 个人博客  www.rockyblog.top */
public interface IAuth {

    boolean validate(String id, String token);

}
