package com.saminboon.baepool.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignInRequest {
    private String user_id;
    private String user_passwd;

    @Builder
    public SignInRequest(String user_id, String user_passwd) {
        this.user_id = user_id;
        this.user_passwd = user_passwd;
    }
}
