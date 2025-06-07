package cn.rockystudio.gateway.core.session.defaults;

import cn.rockystudio.gateway.core.bind.IGenericReference;
import cn.rockystudio.gateway.core.executor.Executor;
import cn.rockystudio.gateway.core.mapping.HttpStatement;
import cn.rockystudio.gateway.core.session.Configuration;
import cn.rockystudio.gateway.core.session.GatewaySession;

import java.util.Map;

/**
 * @author Rocky
 * @description 默认网关会话实现类
 * @github github.com/fuzhengwei
 * @copyright 公众号：rockystudio虫洞栈 | 博客：rockystudio.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class DefaultGatewaySession implements GatewaySession {

    private Configuration configuration;
    private String uri;
    private Executor executor;

    public DefaultGatewaySession(Configuration configuration, String uri, Executor executor) {
        this.configuration = configuration;
        this.uri = uri;
        this.executor = executor;
    }

    @Override
    public Object get(String methodName, Map<String, Object> params) {
        HttpStatement httpStatement = configuration.getHttpStatement(uri);
        try {
            return executor.exec(httpStatement, params);
        } catch (Exception e) {
            throw new RuntimeException("Error exec get. Cause: " + e);
        }
    }

    @Override
    public Object post(String methodName, Map<String, Object> params) {
        return get(methodName, params);
    }

    @Override
    public IGenericReference getMapper() {
        return configuration.getMapper(uri, this);
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }

}
