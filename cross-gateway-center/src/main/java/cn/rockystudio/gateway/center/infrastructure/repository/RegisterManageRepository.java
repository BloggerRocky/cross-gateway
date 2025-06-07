package cn.rockystudio.gateway.center.infrastructure.repository;

import cn.rockystudio.gateway.center.domain.register.model.vo.ApplicationInterfaceMethodVO;
import cn.rockystudio.gateway.center.domain.register.model.vo.ApplicationInterfaceVO;
import cn.rockystudio.gateway.center.domain.register.model.vo.ApplicationSystemVO;
import cn.rockystudio.gateway.center.domain.register.repository.IRegisterManageRepository;
import cn.rockystudio.gateway.center.infrastructure.dao.IApplicationInterfaceDao;
import cn.rockystudio.gateway.center.infrastructure.dao.IApplicationInterfaceMethodDao;
import cn.rockystudio.gateway.center.infrastructure.dao.IApplicationSystemDao;
import cn.rockystudio.gateway.center.infrastructure.po.ApplicationInterface;
import cn.rockystudio.gateway.center.infrastructure.po.ApplicationInterfaceMethod;
import cn.rockystudio.gateway.center.infrastructure.po.ApplicationSystem;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Rocky
 * @description 接口注册仓储服务

* @Copyright 个人博客  www.rockyblog.top */
@Component
public class RegisterManageRepository implements IRegisterManageRepository {

    @Resource
    private IApplicationSystemDao applicationSystemDao;
    @Resource
    private IApplicationInterfaceDao applicationInterfaceDao;
    @Resource
    private IApplicationInterfaceMethodDao applicationInterfaceMethodDao;

    @Override
    public void registerApplication(ApplicationSystemVO applicationSystemVO) {
        boolean exist = applicationSystemDao.isExistBySystemId(applicationSystemVO.getSystemId());
        if(exist) return;
        ApplicationSystem applicationSystem = new ApplicationSystem();
        applicationSystem.setSystemId(applicationSystemVO.getSystemId());
        applicationSystem.setSystemName(applicationSystemVO.getSystemName());
        applicationSystem.setSystemType(applicationSystemVO.getSystemType());
        applicationSystem.setSystemRegistry(applicationSystemVO.getSystemRegistry());
        applicationSystemDao.insert(applicationSystem);
    }

    @Override
    public void registerApplicationInterface(ApplicationInterfaceVO applicationInterfaceVO) {
        ApplicationInterface applicationInterface = new ApplicationInterface();
        applicationInterface.setSystemId(applicationInterfaceVO.getSystemId());
        applicationInterface.setInterfaceId(applicationInterfaceVO.getInterfaceId());
        applicationInterface.setInterfaceName(applicationInterfaceVO.getInterfaceName());
        applicationInterface.setInterfaceVersion(applicationInterfaceVO.getInterfaceVersion());
        boolean exist = applicationInterfaceDao.isExistByInterfaceId(applicationInterface);
        if(exist) return;
        applicationInterfaceDao.insert(applicationInterface);
    }

    @Override
    public void registerApplicationInterfaceMethod(ApplicationInterfaceMethodVO applicationInterfaceMethodVO) {
        ApplicationInterfaceMethod applicationInterfaceMethod = new ApplicationInterfaceMethod();
        applicationInterfaceMethod.setSystemId(applicationInterfaceMethodVO.getSystemId());
        applicationInterfaceMethod.setInterfaceId(applicationInterfaceMethodVO.getInterfaceId());
        applicationInterfaceMethod.setMethodId(applicationInterfaceMethodVO.getMethodId());
        applicationInterfaceMethod.setMethodName(applicationInterfaceMethodVO.getMethodName());
        applicationInterfaceMethod.setParameterType(applicationInterfaceMethodVO.getParameterType());
        applicationInterfaceMethod.setUri(applicationInterfaceMethodVO.getUri());
        applicationInterfaceMethod.setHttpCommandType(applicationInterfaceMethodVO.getHttpCommandType());
        applicationInterfaceMethod.setAuth(applicationInterfaceMethodVO.getAuth());
        boolean exist = applicationInterfaceMethodDao.isExistByInterfaceMethodId(applicationInterfaceMethod);
        if(exist) return;
        applicationInterfaceMethodDao.insert(applicationInterfaceMethod);
    }

    @Override
    public boolean isExistBySystemId(String systemId) {
        return applicationSystemDao.isExistBySystemId(systemId);
    }

}
