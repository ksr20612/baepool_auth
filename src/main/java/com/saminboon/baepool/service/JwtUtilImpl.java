package com.saminboon.baepool.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
@PropertySource("classPath:key.properties")
public class JwtUtilImpl implements JwtUtil{

    @Value("${key}")
    private String signKey;

    private Date timeExpiredforRefreshToken = new Date(System.currentTimeMillis() + 1000 * 3600 * 24 * 14); // 2주 후 expired
    private Date getTimeExpiredforAccessToken = new Date(System.currentTimeMillis() + 1000 * 3600 * 2); // 2시간 후 expired

    @Override
    public String createRefreshToken(String idx) {
        return JWT.create()
                .withIssuer("baepool")
                .withExpiresAt(timeExpiredforRefreshToken)
                .withClaim("idx",idx)
                .sign(Algorithm.HMAC256(signKey));

    }

    @Override
    public void verifyToken(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(signKey))
                .withIssuer("baepool")
                .build();
        verifier.verify(token);
    }

    @Override
    public String createAccessToken(String idx) {
        return JWT.create()
                .withIssuer("baepool")
                .withExpiresAt(getTimeExpiredforAccessToken)
                .withClaim("idx",idx)
                .sign(Algorithm.HMAC256(signKey));
    }
}
