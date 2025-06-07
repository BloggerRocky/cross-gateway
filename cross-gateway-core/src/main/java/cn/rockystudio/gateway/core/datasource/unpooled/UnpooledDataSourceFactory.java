package cn.rockystudio.gateway.core.datasource.unpooled;

import cn.rockystudio.gateway.core.datasource.DataSource;
import cn.rockystudio.gateway.core.datasource.DataSourceFactory;
import cn.rockystudio.gateway.core.datasource.DataSourceType;
import cn.rockystudio.gateway.core.session.Configuration;

/**
 * @author Rocky
 * @description

* @Copyright 个人博客  www.rockyblog.top */
public class UnpooledDataSourceFactory implements DataSourceFactory {

    protected UnpooledDataSource dataSource;

    public UnpooledDataSourceFactory() {
        this.dataSource = new UnpooledDataSource();
    }

    @Override
    public void setProperties(Configuration configuration, String uri) {
        this.dataSource.setConfiguration(configuration);
        this.dataSource.setDataSourceType(DataSourceType.Dubbo);
        this.dataSource.setHttpStatement(configuration.getHttpStatement(uri));
    }

    @Override
    public DataSource getDataSource() {
        return dataSource;
    }

}
