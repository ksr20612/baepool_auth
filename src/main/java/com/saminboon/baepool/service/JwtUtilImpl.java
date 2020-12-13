package com.saminboon.baepool.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@PropertySource("classPath:key.properties")
public class JwtUtilImpl implements JwtUtil{

    @Value("${key}")
    private String signKey;

    private Date timeExpired = new Date(System.currentTimeMillis() + 1000 * 10); // 10초후 expired

    @Override
    public String createToken() {
        return JWT.create()
                .withIssuer("baepool")
                .withExpiresAt(timeExpired)
                .sign(Algorithm.HMAC256(signKey));
    }

    @Override
    public void verifyToken(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(signKey))
                .withIssuer("baepool")
                .build();
        verifier.verify(token);
    }
}
