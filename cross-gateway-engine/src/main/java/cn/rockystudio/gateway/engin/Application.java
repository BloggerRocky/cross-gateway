package cn.rockystudio.gateway.engin;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Rocky
 * @description 启动服务

* @Copyright 个人博客  www.rockyblog.top */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@Configurable
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
