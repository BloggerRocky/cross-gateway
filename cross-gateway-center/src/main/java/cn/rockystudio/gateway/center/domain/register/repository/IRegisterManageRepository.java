package cn.rockystudio.gateway.center.domain.register.repository;

import cn.rockystudio.gateway.center.domain.register.model.vo.ApplicationInterfaceMethodVO;
import cn.rockystudio.gateway.center.domain.register.model.vo.ApplicationInterfaceVO;
import cn.rockystudio.gateway.center.domain.register.model.vo.ApplicationSystemVO;

/**
 * @author Rocky
 * @description 接口注册仓储服务

* @Copyright 个人博客  www.rockyblog.top */
public interface IRegisterManageRepository {

    void registerApplication(ApplicationSystemVO applicationSystemVO);

    void registerApplicationInterface(ApplicationInterfaceVO applicationInterfaceVO);

    void registerApplicationInterfaceMethod(ApplicationInterfaceMethodVO applicationInterfaceMethodVO);

    boolean isExistBySystemId(String systemId);

}
