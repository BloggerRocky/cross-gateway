package cn.rockystudio.gateway.core.test;

import cn.rockystudio.gateway.core.mapping.HttpCommandType;
import cn.rockystudio.gateway.core.mapping.HttpStatement;
import cn.rockystudio.gateway.core.session.Configuration;
import cn.rockystudio.gateway.core.session.defaults.DefaultGatewaySessionFactory;
import cn.rockystudio.gateway.core.socket.GatewaySocketServer;
import io.netty.channel.Channel;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Rocky
 * @description 单元测试

* @Copyright 个人博客  www.rockyblog.top */
public class ApiTest {

    private final Logger logger = LoggerFactory.getLogger(ApiTest.class);

    /**
     * 测试：
     * http://localhost:7397/wg/activity/sayHi?str="10001"
     * 参数：
     * {
     * "str": "10001"
     * }
     * <p>
     * http://localhost:7397/wg/activity/index
     * 参数：
     * {
     * "name":"Rocky",
     * "uid":"10001"
     * }
     */
    @Test
    public void test_gateway() throws InterruptedException, ExecutionException {
        // 1. 创建配置信息加载注册
        Configuration configuration = new Configuration();
        configuration.setHostName("127.0.0.1");
        configuration.setPort(7399);

        // 2. 基于配置构建会话工厂
        DefaultGatewaySessionFactory gatewaySessionFactory = new DefaultGatewaySessionFactory(configuration);

        // 3. 创建启动网关网络服务
        GatewaySocketServer server = new GatewaySocketServer(configuration, gatewaySessionFactory);

        Future<Channel> future = Executors.newFixedThreadPool(2).submit(server);
        Channel channel = future.get();

        if (null == channel) throw new RuntimeException("netty server start error channel is null");

        while (!channel.isActive()) {
            logger.info("netty server gateway start Ing ...");
            Thread.sleep(500);
        }
        logger.info("netty server gateway start Done! {}", channel.localAddress());

        // 4. 注册接口
        configuration.registryConfig("cross-gateway-test-provider", "zookeeper://192.168.1.102:2181", "cn.rockystudio.gateway.rpc.IActivityBooth", "1.0.0");

        HttpStatement httpStatement01 = new HttpStatement(
                "cross-gateway-test-provider",
                "cn.rockystudio.gateway.rpc.IActivityBooth",
                "sayHi",
                "java.lang.String",
                "/wg/activity/sayHi",
                HttpCommandType.GET,
                false);

//        HttpStatement httpStatement02 = new HttpStatement(
//                "cross-gateway-test",
//                "cn.rockystudio.gateway.rpc.IActivityBooth",
//                "insert",
//                "cn.rockystudio.gateway.rpc.dto.XReq",
//                "/wg/activity/insert",
//                HttpCommandType.POST,
//                true);

        configuration.addMapper(httpStatement01);
//        configuration.addMapper(httpStatement02);

        Thread.sleep(Long.MAX_VALUE);
    }

}
