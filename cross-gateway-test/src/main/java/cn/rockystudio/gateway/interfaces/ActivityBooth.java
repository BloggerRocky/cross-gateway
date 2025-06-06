package cn.rockystudio.gateway.interfaces;

import cn.rockystudio.gateway.rpc.IActivityBooth;
import cn.rockystudio.gateway.rpc.dto.XReq;
import cn.rockystudio.gateway.sdk.annotation.ApiProducerClazz;
import cn.rockystudio.gateway.sdk.annotation.ApiProducerMethod;
import com.alibaba.fastjson.JSON;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
@ApiProducerClazz(interfaceName = "活动服务", interfaceVersion = "1.0.0")
public class ActivityBooth implements IActivityBooth {

    @Override
    @ApiProducerMethod(methodName = "探活方法", uri = "/wg/activity/sayHi", httpCommandType = "GET", auth = 0)
    public String sayHi(String str) {
        return "hi " + str + " by cross-gateway-test-provider";
    }

    @Override
    @ApiProducerMethod(methodName = "插入方法", uri = "/wg/activity/insert", httpCommandType = "POST", auth = 1)
    public String insert(XReq req) {
        return "hi " + JSON.toJSONString(req) + " by cross-gateway-test-provider";
    }

    @Override
    @ApiProducerMethod(methodName = "测试方法", uri = "/wg/activity/test", httpCommandType = "POST", auth = 0)
    public String test(String str, XReq req) {
        return "hi " + str + JSON.toJSONString(req) + " by cross-gateway-test-provider";
    }

}
