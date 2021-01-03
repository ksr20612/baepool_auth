package com.saminboon.baepool.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Tokens {

    private String refreshToken;
    private String accessToken;

    @Builder
    public Tokens(String refreshToken, String accessToken) {
        this.refreshToken = refreshToken;
        this.accessToken = accessToken;
    }
}
