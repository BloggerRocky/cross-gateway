package cn.rockystudio.gateway.center.infrastructure.dao;

import cn.rockystudio.gateway.center.domain.operation.model.vo.ApplicationInterfaceDataVO;
import cn.rockystudio.gateway.center.infrastructure.common.OperationRequest;
import cn.rockystudio.gateway.center.infrastructure.po.ApplicationInterface;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Rocky
 * @description 应用接口

* @Copyright 个人博客  www.rockyblog.top */
@Mapper
public interface IApplicationInterfaceDao {

    void insert(ApplicationInterface applicationInterface);

    List<ApplicationInterface> queryApplicationInterfaceList(String systemId);

    List<ApplicationInterface> queryApplicationInterfaceListByPage(OperationRequest<ApplicationInterfaceDataVO> request);

    int queryApplicationInterfaceListCountByPage(OperationRequest<ApplicationInterfaceDataVO> request);

    boolean isExistByInterfaceId(ApplicationInterface applicationInterface);

}
