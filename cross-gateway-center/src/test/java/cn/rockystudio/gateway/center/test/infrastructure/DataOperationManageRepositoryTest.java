package cn.rockystudio.gateway.center.test.infrastructure;

import cn.rockystudio.gateway.center.domain.operation.model.vo.ApplicationSystemDataVO;
import cn.rockystudio.gateway.center.domain.operation.model.vo.GatewayServerDataVO;
import cn.rockystudio.gateway.center.domain.operation.repository.IDataOperationManageRepository;
import cn.rockystudio.gateway.center.infrastructure.common.OperationRequest;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Rocky
 * @description 仓储服务测试

* @Copyright 个人博客  www.rockyblog.top */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DataOperationManageRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(DataOperationManageRepositoryTest.class);

    @Resource
    private IDataOperationManageRepository repository;

    @Test
    public void test_queryGatewayServerListByPage() {
        OperationRequest<String> req = new OperationRequest<>(1, 10);
        req.setData("");
        List<GatewayServerDataVO> res = repository.queryGatewayServerListByPage(req);
        logger.info("测试结果 req：{}  res：{}", JSON.toJSONString(req), JSON.toJSONString(res));
    }

    @Test
    public void test_queryGatewayServerListCountByPage() {
        OperationRequest<String> req = new OperationRequest<>(1, 10);
        req.setData("10001");
        int res = repository.queryGatewayServerListCountByPage(req);
        logger.info("测试结果 req：{}  res：{}", JSON.toJSONString(req), JSON.toJSONString(res));
    }

    @Test
    public void test_queryApplicationSystemListByPage(){
        OperationRequest<ApplicationSystemDataVO> req = new OperationRequest<>(1, 10);
        req.setData(new ApplicationSystemDataVO("", "网关sdk测试工程"));
        List<ApplicationSystemDataVO> res = repository.queryApplicationSystemListByPage(req);
        logger.info("测试结果 req：{}  res：{}", JSON.toJSONString(req), JSON.toJSONString(res));
    }

}
