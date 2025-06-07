package cn.rockystudio.gateway.center.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 作者：Rocky23318
 * 时间：2025.2025/1/17.12:28
 * 项目名：cross-gateway
 */
@ConfigurationProperties(prefix = "gateway-center-config")
public class GatewayCenterProperties {
    private String registryCenterAddress;
}
