package cn.rockystudio.gateway.sdk.config;

import cn.rockystudio.gateway.sdk.application.GatewaySDKApplication;
import cn.rockystudio.gateway.sdk.domain.service.GatewayCenterService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Rocky
 * @description 网关SDK配置服务

* @Copyright 个人博客  www.rockyblog.top */
@Configuration
@EnableConfigurationProperties(GatewaySDKServiceProperties.class)
@ConditionalOnProperty(
        prefix = "cross-gateway-sdk",
        name = "enabled",
        havingValue = "true",
        matchIfMissing = true
)
public class GatewaySDKAutoConfig {

    @Bean
    public GatewayCenterService gatewayCenterService() {
        return new GatewayCenterService();
    }

    @Bean
    public GatewaySDKApplication gatewaySDKApplication(GatewaySDKServiceProperties properties, GatewayCenterService gatewayCenterService) {
        return new GatewaySDKApplication(properties, gatewayCenterService);
    }

}
