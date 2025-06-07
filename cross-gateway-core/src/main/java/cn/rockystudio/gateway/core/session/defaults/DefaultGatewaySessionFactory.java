package cn.rockystudio.gateway.core.session.defaults;

import cn.rockystudio.gateway.core.datasource.DataSource;
import cn.rockystudio.gateway.core.datasource.DataSourceFactory;
import cn.rockystudio.gateway.core.datasource.unpooled.UnpooledDataSourceFactory;
import cn.rockystudio.gateway.core.executor.Executor;
import cn.rockystudio.gateway.core.session.Configuration;
import cn.rockystudio.gateway.core.session.GatewaySession;
import cn.rockystudio.gateway.core.session.GatewaySessionFactory;

/**
 * @author Rocky
 * @description 默认网关会话工厂

* @Copyright 个人博客  www.rockyblog.top */
public class DefaultGatewaySessionFactory implements GatewaySessionFactory {

    private final Configuration configuration;

    public DefaultGatewaySessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public GatewaySession openSession(String uri) {
        // 获取数据源连接信息：这里把 Dubbo、HTTP 抽象为一种连接资源
        DataSourceFactory dataSourceFactory = new UnpooledDataSourceFactory();
        dataSourceFactory.setProperties(configuration, uri);
        DataSource dataSource = dataSourceFactory.getDataSource();
        // 创建执行器
        Executor executor = configuration.newExecutor(dataSource.getConnection());
        // 创建会话：DefaultGatewaySession
        return new DefaultGatewaySession(configuration, uri, executor);
    }

    public Configuration getConfiguration() {
        return configuration;
    }

}
