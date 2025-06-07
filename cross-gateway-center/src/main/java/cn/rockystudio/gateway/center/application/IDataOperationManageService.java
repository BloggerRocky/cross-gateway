package cn.rockystudio.gateway.center.application;

import cn.rockystudio.gateway.center.domain.operation.model.vo.*;
import cn.rockystudio.gateway.center.infrastructure.common.OperationRequest;
import cn.rockystudio.gateway.center.infrastructure.common.OperationResult;

/**
 * @author Rocky
 * @description 网关运营数据管理

* @Copyright 个人博客  www.rockyblog.top */
public interface IDataOperationManageService {

    OperationResult<GatewayServerDataVO> queryGatewayServer(OperationRequest<String> request);

    OperationResult<ApplicationSystemDataVO> queryApplicationSystem(OperationRequest<ApplicationSystemDataVO> request);

    OperationResult<ApplicationInterfaceDataVO> queryApplicationInterface(OperationRequest<ApplicationInterfaceDataVO> request);

    OperationResult<ApplicationInterfaceMethodDataVO> queryApplicationInterfaceMethod(OperationRequest<ApplicationInterfaceMethodDataVO> request);

    OperationResult<GatewayServerDetaiDatalVO> queryGatewayServerDetail(OperationRequest<GatewayServerDetaiDatalVO> request);

    OperationResult<GatewayDistributionDataVO> queryGatewayDistribution(OperationRequest<GatewayDistributionDataVO> request);

}
