package cn.rockystudio.gateway.core.datasource;

/**
 * @author Rocky
 * @description 数据源接口，RPC、HTTP 都当做连接的数据资源使用

* @Copyright 个人博客  www.rockyblog.top */
public interface DataSource {

    Connection getConnection();

}
