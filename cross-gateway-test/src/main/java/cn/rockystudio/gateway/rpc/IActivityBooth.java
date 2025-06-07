package cn.rockystudio.gateway.rpc;

import cn.rockystudio.gateway.rpc.dto.XReq;

public interface IActivityBooth {

    String sayHi(String str);

    String insert(XReq req);

    String test(String str, XReq req);

}
