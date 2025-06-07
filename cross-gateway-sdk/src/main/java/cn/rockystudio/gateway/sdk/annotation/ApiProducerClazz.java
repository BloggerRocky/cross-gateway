package cn.rockystudio.gateway.sdk.annotation;

import java.lang.annotation.*;

/**
 * @author Rocky
 * @description 网关API生产者自定义注解

* @Copyright 个人博客  www.rockyblog.top */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface ApiProducerClazz {

    /** 接口名称 */
    String interfaceName() default "";

    /** 接口版本 */
    String interfaceVersion() default "";
}
