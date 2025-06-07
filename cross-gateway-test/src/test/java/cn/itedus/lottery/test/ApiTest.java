package cn.itedus.lottery.test;

import cn.rockystudio.gateway.rpc.dto.XReq;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    public static void main(String[] args) {
        XReq req = new XReq();
        req.setUid("10001");
        req.setName("Rocky");

        System.out.println(JSON.toJSONString(req));
    }

}
