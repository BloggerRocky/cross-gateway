package cn.rockystudio.gateway.core.datasource;

import cn.rockystudio.gateway.core.session.Configuration;

/**
 * @author Rocky
 * @description 数据源工厂

* @Copyright 个人博客  www.rockyblog.top */
public interface DataSourceFactory {

    void setProperties(Configuration configuration, String uri);

    DataSource getDataSource();

}
