package cn.rockystudio.gateway.center.domain.manage.model.vo;

/**
 * @author Rocky
 * @description 网关服务配置

* @Copyright 个人博客  www.rockyblog.top */
public class GatewayServerVO {

    /** 分组标识 */
    private String groupId;
    /** 分组名称 */
    private String groupName;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

}
