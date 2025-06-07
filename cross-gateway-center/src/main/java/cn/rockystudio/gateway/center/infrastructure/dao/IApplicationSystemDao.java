package cn.rockystudio.gateway.center.infrastructure.dao;

import cn.rockystudio.gateway.center.domain.operation.model.vo.ApplicationSystemDataVO;
import cn.rockystudio.gateway.center.infrastructure.common.OperationRequest;
import cn.rockystudio.gateway.center.infrastructure.po.ApplicationSystem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Rocky
 * @description 应用系统

* @Copyright 个人博客  www.rockyblog.top */
@Mapper
public interface IApplicationSystemDao {

    void insert(ApplicationSystem applicationSystem);

    List<ApplicationSystem> queryApplicationSystemList(List<String> list);

    List<ApplicationSystem> queryApplicationSystemListByPage(OperationRequest<ApplicationSystemDataVO> request);

    int queryApplicationSystemListCountByPage(OperationRequest<ApplicationSystemDataVO> request);

    String queryApplicationSystemName(String systemId);

    boolean isExistBySystemId(String systemId);

}
