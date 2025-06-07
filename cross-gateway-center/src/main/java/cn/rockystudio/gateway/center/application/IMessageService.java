package cn.rockystudio.gateway.center.application;

import java.util.Map;

/**
 * @author Rocky
 * @description 消息服务

* @Copyright 个人博客  www.rockyblog.top */
public interface IMessageService {

    Map<String, String> queryRedisConfig();

    void pushMessage(String gatewayId, Object message);

}
