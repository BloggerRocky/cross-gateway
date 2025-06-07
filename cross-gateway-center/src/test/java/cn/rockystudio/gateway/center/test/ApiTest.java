package cn.rockystudio.gateway.center.test;

import cn.rockystudio.gateway.center.application.IConfigManageService;
import cn.rockystudio.gateway.center.application.IRegisterManageService;
import cn.rockystudio.gateway.center.domain.manage.model.aggregates.ApplicationSystemRichInfo;
import cn.rockystudio.gateway.center.domain.manage.model.vo.GatewayDistributionVO;
import cn.rockystudio.gateway.center.domain.manage.model.vo.GatewayServerDetailVO;
import cn.rockystudio.gateway.center.domain.manage.model.vo.GatewayServerVO;
import cn.rockystudio.gateway.center.domain.message.Publisher;
import cn.rockystudio.gateway.center.domain.register.model.vo.ApplicationInterfaceMethodVO;
import cn.rockystudio.gateway.center.domain.register.model.vo.ApplicationInterfaceVO;
import cn.rockystudio.gateway.center.domain.register.model.vo.ApplicationSystemVO;
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
 * @description 单元测试

* @Copyright 个人博客  www.rockyblog.top */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Resource
    private IConfigManageService configManageService;

    @Resource
    private IRegisterManageService registerManageService;

    @Test
    public void test_queryGatewayServerList() {
        List<GatewayServerVO> gatewayServerVOS = configManageService.queryGatewayServerList();
        logger.info("测试结果：{}", JSON.toJSONString(gatewayServerVOS));
    }

    @Test
    public void test_queryGatewayServerDetailList() {
        List<GatewayServerDetailVO> gatewayServerVOS = configManageService.queryGatewayServerDetailList();
        logger.info("测试结果：{}", JSON.toJSONString(gatewayServerVOS));
    }

    @Test
    public void test_queryGatewayDistributionList() {
        List<GatewayDistributionVO> gatewayDistributionVOList = configManageService.queryGatewayDistributionList();
        logger.info("测试结果：{}", JSON.toJSONString(gatewayDistributionVOList));
    }

    @Test
    public void test_application() {
        logger.info("测试结果：{}", JSON.toJSONString(configManageService.queryApplicationSystemList()));
        logger.info("测试结果：{}", JSON.toJSONString(configManageService.queryApplicationInterfaceList()));
        logger.info("测试结果：{}", JSON.toJSONString(configManageService.queryApplicationInterfaceMethodList()));
    }

    @Test
    public void test_registerGatewayServerNode() {
        configManageService.registerGatewayServerNode("10001", "cross-gateway-g4", "电商支付网关", "172.20.10.12:7399");
    }

    @Test
    public void test_registerApplication() {
        ApplicationSystemVO applicationSystemVO = new ApplicationSystemVO();
        applicationSystemVO.setSystemId("cross-gateway-test");
        applicationSystemVO.setSystemName("网关测试系统");
        applicationSystemVO.setSystemType("RPC");
        applicationSystemVO.setSystemRegistry("127.0.0.1");
        registerManageService.registerApplication(applicationSystemVO);
    }

    @Test
    public void test_registerApplicationInterface() {
        ApplicationInterfaceVO applicationInterfaceVO = new ApplicationInterfaceVO();
        applicationInterfaceVO.setSystemId("cross-gateway-test");
        applicationInterfaceVO.setInterfaceId("cn.rockystudio.gateway.rpc.IActivityBooth");
        applicationInterfaceVO.setInterfaceName("活动平台");
        applicationInterfaceVO.setInterfaceVersion("v1.0.0");
        registerManageService.registerApplicationInterface(applicationInterfaceVO);
    }

    @Test
    public void test_registerApplicationInterfaceMethod() {
        ApplicationInterfaceMethodVO applicationInterfaceVO01 = new ApplicationInterfaceMethodVO();
        applicationInterfaceVO01.setSystemId("cross-gateway-test");
        applicationInterfaceVO01.setInterfaceId("cn.rockystudio.gateway.rpc.IActivityBooth");
        applicationInterfaceVO01.setMethodId("sayHi");
        applicationInterfaceVO01.setMethodName("测试方法");
        applicationInterfaceVO01.setParameterType("java.lang.String");
        applicationInterfaceVO01.setUri("/wg/activity/sayHi");
        applicationInterfaceVO01.setHttpCommandType("GET");
        applicationInterfaceVO01.setAuth(0);
        registerManageService.registerApplicationInterfaceMethod(applicationInterfaceVO01);

        ApplicationInterfaceMethodVO applicationInterfaceVO02 = new ApplicationInterfaceMethodVO();
        applicationInterfaceVO02.setSystemId("cross-gateway-test");
        applicationInterfaceVO02.setInterfaceId("cn.rockystudio.gateway.rpc.IActivityBooth");
        applicationInterfaceVO02.setMethodId("insert");
        applicationInterfaceVO02.setMethodName("插入方法");
        applicationInterfaceVO02.setParameterType("cn.rockystudio.gateway.rpc.dto.XReq");
        applicationInterfaceVO02.setUri("/wg/activity/insert");
        applicationInterfaceVO02.setHttpCommandType("POST");
        applicationInterfaceVO02.setAuth(1);
        registerManageService.registerApplicationInterfaceMethod(applicationInterfaceVO02);
    }

    @Test
    public void test_queryApplicationSystemRichInfo() {
        ApplicationSystemRichInfo result = configManageService.queryApplicationSystemRichInfo("cross-gateway-g4", "");
        logger.info("测试结果：{}", JSON.toJSONString(result));
    }

    @Resource
    private Publisher publisher;

    @Test
    public void test_messages() throws InterruptedException {
        publisher.pushMessage("cross-gateway-g4", "cross-gateway-test-provider");
        Thread.sleep(50000);
    }

}
