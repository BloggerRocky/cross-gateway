package cn.rockystudio.gateway.center.infrastructure.dao;

import cn.rockystudio.gateway.center.domain.operation.model.vo.GatewayServerDetaiDatalVO;
import cn.rockystudio.gateway.center.infrastructure.common.OperationRequest;
import cn.rockystudio.gateway.center.infrastructure.po.GatewayServerDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Rocky
 * @description

* @Copyright 个人博客  www.rockyblog.top */
@Mapper
public interface IGatewayServerDetailDao {

    void insert(GatewayServerDetail gatewayServerDetail);

    GatewayServerDetail queryGatewayServerDetail(GatewayServerDetail gatewayServerDetail);

    boolean updateGatewayStatus(GatewayServerDetail gatewayServerDetail);

    List<GatewayServerDetail> queryGatewayServerDetailList();

    List<GatewayServerDetail> queryGatewayServerDetailListByPage(OperationRequest<GatewayServerDetaiDatalVO> request);

    int queryGatewayServerDetailListCountByPage(OperationRequest<GatewayServerDetaiDatalVO> request);

}
