package com.saminboon.baepool.service;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignUpRequest {

    private String user_id;
    private String user_passwd;
    private String user_name;
    private String user_mail;
    private String user_age;
    private String user_gender;
    private String user_birthday;
    private String user_phone;
    private String user_create_time;
    private String comp_name;
    private String team_name;

    @Builder
    public SignUpRequest(String user_id, String user_passwd, String user_name, String user_mail, String user_age, String user_gender, String user_birthday, String user_phone, String user_create_time, String comp_name, String team_name) {
        this.user_id = user_id;
        this.user_passwd = user_passwd;
        this.user_name = user_name;
        this.user_mail = user_mail;
        this.user_age = user_age;
        this.user_gender = user_gender;
        this.user_birthday = user_birthday;
        this.user_phone = user_phone;
        this.user_create_time = user_create_time;
        this.comp_name = comp_name;
        this.team_name = team_name;
    }
}
