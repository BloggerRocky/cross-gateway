package cn.rockystudio.gateway.core.bind;

import cn.rockystudio.gateway.core.executor.result.SessionResult;

import java.util.Map;

/**
 * @author Rocky
 * @description 统一泛化调用接口
 * @github github.com/fuzhengwei
 * @copyright 公众号：rockystudio虫洞栈 | 博客：rockystudio.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public interface IGenericReference {

    SessionResult $invoke(Map<String, Object> params);

}
