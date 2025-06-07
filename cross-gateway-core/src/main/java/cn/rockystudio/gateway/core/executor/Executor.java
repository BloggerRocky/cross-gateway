package cn.rockystudio.gateway.core.executor;

import cn.rockystudio.gateway.core.executor.result.SessionResult;
import cn.rockystudio.gateway.core.mapping.HttpStatement;

import java.util.Map;

/**
 * @author Rocky
 * @description 执行器

* @Copyright 个人博客  www.rockyblog.top */
public interface Executor {

    SessionResult exec(HttpStatement httpStatement, Map<String, Object> params) throws Exception;

}
