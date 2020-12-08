package com.saminboon.baepool.service;

public interface JwtUtil {
    String createToken();
    void verifyToken(String token);
}
