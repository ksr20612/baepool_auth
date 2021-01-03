package com.saminboon.baepool.service;

public interface JwtUtil {
    String createRefreshToken(String idx);
    String createAccessToken(String idx);
    void verifyToken(String token);
}
