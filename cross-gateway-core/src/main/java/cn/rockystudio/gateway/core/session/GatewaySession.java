package cn.rockystudio.gateway.core.session;

import cn.rockystudio.gateway.core.bind.IGenericReference;

import java.util.Map;

/**
 * @author Rocky
 * @description 用户处理网关 HTTP 请求
 * @github github.com/fuzhengwei
 * @copyright 公众号：rockystudio虫洞栈 | 博客：rockystudio.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public interface GatewaySession {

    Object get(String methodName, Map<String, Object> params);

    Object post(String methodName, Map<String, Object> params);

    IGenericReference getMapper();

    Configuration getConfiguration();
}
