package cn.rockystudio.gateway.center.application;

import cn.rockystudio.gateway.center.domain.docker.model.aggregates.NginxConfig;

/**
 * @author Rocky
 * @description 负载均衡配置服务

* @Copyright 个人博客  www.rockyblog.top */
public interface ILoadBalancingService {

    void updateNginxConfig(NginxConfig nginxConfig) throws Exception;

}
