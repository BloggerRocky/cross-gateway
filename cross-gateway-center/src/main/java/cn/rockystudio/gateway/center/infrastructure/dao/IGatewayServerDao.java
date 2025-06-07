package cn.rockystudio.gateway.center.infrastructure.dao;

import cn.rockystudio.gateway.center.infrastructure.common.OperationRequest;
import cn.rockystudio.gateway.center.infrastructure.po.GatewayServer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Rocky
 * @description

* @Copyright 个人博客  www.rockyblog.top */
@Mapper
public interface IGatewayServerDao {

    List<GatewayServer> queryGatewayServerList();

    List<GatewayServer> queryGatewayServerListByPage(OperationRequest<String> request);

    int queryGatewayServerListCountByPage(OperationRequest<String> request);

}
