package cn.rockystudio.gateway.center.domain.register.service;

import cn.rockystudio.gateway.center.application.IRegisterManageService;
import cn.rockystudio.gateway.center.domain.register.model.vo.ApplicationInterfaceMethodVO;
import cn.rockystudio.gateway.center.domain.register.model.vo.ApplicationInterfaceVO;
import cn.rockystudio.gateway.center.domain.register.model.vo.ApplicationSystemVO;
import cn.rockystudio.gateway.center.domain.register.repository.IRegisterManageRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Rocky
 * @description 接口注册服务

* @Copyright 个人博客  www.rockyblog.top */
@Service
public class IRegisterManageServiceImpl implements IRegisterManageService {

    @Resource
    private IRegisterManageRepository registerManageRepository;

    @Override
    public void registerApplication(ApplicationSystemVO applicationSystemVO) {
        registerManageRepository.registerApplication(applicationSystemVO);
    }

    @Override
    public void registerApplicationInterface(ApplicationInterfaceVO applicationInterfaceVO) {
        registerManageRepository.registerApplicationInterface(applicationInterfaceVO);
    }

    @Override
    public void registerApplicationInterfaceMethod(ApplicationInterfaceMethodVO applicationInterfaceMethodVO) {
        registerManageRepository.registerApplicationInterfaceMethod(applicationInterfaceMethodVO);
    }

}
