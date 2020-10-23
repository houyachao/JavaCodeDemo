package com.example.javacodedemo.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

/**
 * @author HYC
 */
public class JWTUtils {

    private static String SECRET = "token!Q@W#E$R";

    /**
     * 生产token
     */
    public static String getToken(Map<String, Object> map) {

        JWTCreator.Builder builder = JWT.create();

        // payload
        map.forEach((k, v) -> {
            builder.withClaim(k, (String) v);
        });

        // 默认7天过期 , 指定令牌的过期时间  签名
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 7);

        builder.withExpiresAt(instance.getTime());
        String token = builder.sign(Algorithm.HMAC256(SECRET));

        return token;
    }

    /**
     * 验证token
     */
    public static DecodedJWT verify(String token) {
        //如果有任何验证异常，此处都会抛出异常
        DecodedJWT decodedJwt = JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
        return decodedJwt;
    }

}
