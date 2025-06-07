package cn.rockystudio.gateway.center.application;

import cn.rockystudio.gateway.center.domain.manage.model.aggregates.ApplicationSystemRichInfo;
import cn.rockystudio.gateway.center.domain.manage.model.vo.*;

import java.util.List;

/**
 * @author Rocky
 * @description 网关配置服务

* @Copyright 个人博客  www.rockyblog.top */
public interface IConfigManageService {

    List<GatewayServerVO> queryGatewayServerList();

    List<GatewayServerDetailVO> queryGatewayServerDetailList();

    List<GatewayDistributionVO> queryGatewayDistributionList();

    boolean registerGatewayServerNode(String groupId, String gatewayId, String gatewayName, String gatewayAddress);

    ApplicationSystemRichInfo queryApplicationSystemRichInfo(String gatewayId, String systemId);

    String queryGatewayDistribution(String systemId);

    List<ApplicationSystemVO> queryApplicationSystemList();

    List<ApplicationInterfaceVO> queryApplicationInterfaceList();

    List<ApplicationInterfaceMethodVO> queryApplicationInterfaceMethodList();

    void distributionGatewayServerNode(String groupId, String gatewayId, String systemId);

}
