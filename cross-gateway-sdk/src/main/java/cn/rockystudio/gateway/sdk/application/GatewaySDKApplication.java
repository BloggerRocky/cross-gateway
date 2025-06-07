package cn.rockystudio.gateway.sdk.application;

import cn.rockystudio.gateway.sdk.GatewayException;
import cn.rockystudio.gateway.sdk.annotation.ApiProducerClazz;
import cn.rockystudio.gateway.sdk.annotation.ApiProducerMethod;
import cn.rockystudio.gateway.sdk.common.Constants;
import cn.rockystudio.gateway.sdk.config.GatewaySDKServiceProperties;
import cn.rockystudio.gateway.sdk.domain.service.GatewayCenterService;
import com.alibaba.fastjson.JSON;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author Rocky
 * @description 应用服务注册

* @Copyright 个人博客  www.rockyblog.top */
public class GatewaySDKApplication implements BeanPostProcessor {

    private Logger logger = LoggerFactory.getLogger(GatewaySDKApplication.class);

    private GatewaySDKServiceProperties properties;
    private GatewayCenterService gatewayCenterService;

    public GatewaySDKApplication(GatewaySDKServiceProperties properties, GatewayCenterService gatewayCenterService) {
        this.properties = properties;
        this.gatewayCenterService = gatewayCenterService;
    }
    @PostConstruct
    public void registryApplication(){
        // 1. 系统信息
        logger.info("\n应用注册：系统信息 \nsystemId: {} \nsystemName: {} \nsystemType: {} \nsystemRegistry: {}", properties.getSystemId(), properties.getSystemName(), "RPC", properties.getSystemRegistry());
        gatewayCenterService.doRegisterApplication(properties.getAddress(), properties.getSystemId(), properties.getSystemName(), "RPC", properties.getSystemRegistry());
    }
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        ApiProducerClazz apiProducerClazz = bean.getClass().getAnnotation(ApiProducerClazz.class);
        if (null == apiProducerClazz)
            return bean;
        // 1. 注册接口信息
        Class<?>[] interfaces = bean.getClass().getInterfaces();
        if (interfaces.length != 1) {
            throw new GatewayException(bean.getClass().getName() + "interfaces not one this is " + JSON.toJSONString(interfaces));
        }
        String interfaceId = interfaces[0].getName();
        logger.info("\n应用注册：接口信息 \nsystemId: {} \ninterfaceId: {} \ninterfaceName: {} \ninterfaceVersion: {}", properties.getSystemId(), interfaceId, apiProducerClazz.interfaceName(), apiProducerClazz.interfaceVersion());
        gatewayCenterService.doRegisterApplicationInterface(properties.getAddress(),
                properties.getSystemId(),
                interfaceId,
                apiProducerClazz.interfaceName(),
                apiProducerClazz.interfaceVersion());

        // 2. 注册接口中的方法信息
        Method[] methods = bean.getClass().getMethods();
        for (Method method : methods) {
            ApiProducerMethod apiProducerMethod = method.getAnnotation(ApiProducerMethod.class);
            if (apiProducerMethod == null) continue;
            // 解析参数
            Class<?>[] parameterTypes = method.getParameterTypes();
            StringBuilder parameters = new StringBuilder();
            for (Class<?> clazz : parameterTypes) {
                parameters.append(clazz.getName()).append(",");
            }
            String parameterType = parameters.toString().substring(0, parameters.toString().lastIndexOf(","));
            logger.info("\n应用注册：方法信息 \nsystemId: {} \ninterfaceId: {} \nmethodId: {} \nmethodName: {} \nparameterType: {} \nuri: {} \nhttpCommandType: {} \nauth: {}",
                    properties.getSystemId(),
                    interfaceId,
                    method.getName(),
                    apiProducerMethod.methodName(),
                    parameterType,
                    apiProducerMethod.uri(),
                    apiProducerMethod.httpCommandType(),
                    apiProducerMethod.auth());
            gatewayCenterService.doRegisterApplicationInterfaceMethod(properties.getAddress(),
                    properties.getSystemId(),
                    interfaceId,
                    method.getName(),
                    apiProducerMethod.methodName(),
                    parameterType,
                    apiProducerMethod.uri(),
                    apiProducerMethod.httpCommandType(),
                    apiProducerMethod.auth());
        }
        try {
            createEphemeralNode(properties.getSystemRegistry(),properties.getSystemId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // 注册完成，执行事件通知
        gatewayCenterService.doRegisterEvent(properties.getAddress(), properties.getSystemId());
        return bean;
    }
    public void createEphemeralNode(String registryAddress,String systemId) throws IOException, InterruptedException, KeeperException {
        String path = Constants.EPHEMERAL_NODE_PATH + "/" +systemId;
        ZooKeeper zk = new ZooKeeper(registryAddress, 5000, event -> {});
        // 创建临时节点
        zk.create(path, systemId.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println("临时节点已创建：" + path+systemId);

    }
}
