package cn.rockystudio.gateway.center.infrastructure.dao;

import cn.rockystudio.gateway.center.domain.manage.model.vo.GatewayDistributionVO;
import cn.rockystudio.gateway.center.domain.operation.model.vo.GatewayDistributionDataVO;
import cn.rockystudio.gateway.center.infrastructure.common.OperationRequest;
import cn.rockystudio.gateway.center.infrastructure.po.GatewayDistribution;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Rocky
 * @description 网关分配

* @Copyright 个人博客  www.rockyblog.top */
@Mapper
public interface IGatewayDistributionDao {

    List<String> queryGatewayDistributionSystemIdList(String gatewayId);

    String queryGatewayDistribution(String systemId);

    List<GatewayDistribution> queryGatewayDistributionList();

    List<GatewayDistribution> queryGatewayDistributionListByPage(OperationRequest<GatewayDistributionDataVO> request);

    int queryGatewayDistributionListCountByPage(OperationRequest<GatewayDistributionDataVO> request);

    void insert(GatewayDistributionVO gatewayDistribution);

}
