package cn.rockystudio.gateway.core.test;

import cn.rockystudio.gateway.core.authorization.IAuth;
import cn.rockystudio.gateway.core.authorization.JwtUtil;
import cn.rockystudio.gateway.core.authorization.auth.AuthService;
import io.jsonwebtoken.Claims;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rocky
 * @description shiro + jwt
* @Copyright 个人博客  www.rockyblog.top
 */
public class ShiroTest {

    private final static Logger logger = LoggerFactory.getLogger(ShiroTest.class);

    @Test
    public void test_auth_service() {
        IAuth auth = new AuthService();
        boolean validate = auth.validate("rocky", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ4aWFvZnVnZSIsImV4cCI6MTY2NjQwNDAxMiwiaWF0IjoxNjY1Nzk5MjEyLCJrZXkiOiJ4aWFvZnVnZSJ9.Vs-ObO5OF2pYr7jkt0N4goq0hErOZNdyqfacHzbkfHM");
        System.out.println(validate ? "验证成功" : "验证失败");
    }

    @Test
    public void test_awt() {
        String issuer = "rocky";
        long ttlMillis = 7 * 24 * 60 * 60 * 1000L;
        Map<String, Object> claims = new HashMap<>();
        claims.put("key", "rocky");

        // 编码
        String token = JwtUtil.encode(issuer, ttlMillis, claims);
        System.out.println(token);

        // 解码
        Claims parser = JwtUtil.decode(token);
        System.out.println(parser.getSubject());
    }

}
