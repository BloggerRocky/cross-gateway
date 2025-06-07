package cn.rockystudio.gateway.center.domain.manage.service;

import cn.rockystudio.gateway.center.configuration.GatewayCenterProperties;
import cn.rockystudio.gateway.center.infrastructure.common.Constants;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 作者：Rocky23318
 * 时间：2025.2025/1/13.13:08
 * 项目名：cross-gateway
 */
@Service
public class ZookeeperService {
    @Autowired
    ConfigManageService manageService;
    @Autowired
    GatewayCenterProperties properties;
    Logger logger = null;
    public void watchServerNode(String systemId) throws Exception {
        String connectString = properties.getSystemRegistryAddress();
        String path = Constants.EPHEMERAL_NODE_PATH +"/" + systemId;
        CuratorFramework client = CuratorFrameworkFactory.newClient(
                connectString,
                new ExponentialBackoffRetry(1000, 3)
        );
        client.start();
        // 创建 CuratorCache 实例
        CuratorCache cache = CuratorCache.build(client, path);
        // 添加监听器，监听节点删除事件
        CuratorCacheListener listener = CuratorCacheListener.builder()
                .forDeletes(old -> {
                    logger.warn("服务节点{}已下线：" + systemId);
                    manageService.removeGatewayServerNode(systemId);
                })
                .build();

        Listenable<CuratorCacheListener> listenable = cache.listenable();
        listenable.addListener(listener);
        // 启动缓存监听
        cache.start();
        logger.info("开始监听节点{}的状态",systemId);
    }
}
