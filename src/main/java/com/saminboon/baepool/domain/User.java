package com.saminboon.baepool.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_idx;

    @Column(nullable = false)
    private String user_id;
    @Column(nullable = false)
    private String user_passwd;
    @Column
    private String user_name;
    @Column
    private String user_mail;
    @Column
    private String user_age;
    @Column
    private String user_gender;
    @Column
    private String user_birthday;
    @Column
    private String user_birthyear;
    @Column
    private String user_phone;
    @Column
    private String user_create_time;
    @Column(nullable = false)
    private String comp_name;
    @Column(nullable = false)
    private String team_name;
    @Column
    private String user_token;
    @Column
    private String user_img;
    @Column
    private String user_role;

    @Builder
    public User(int user_idx, String user_id, String user_passwd, String user_name, String user_mail, String user_age, String user_gender, String user_birthday, String user_birthyear, String user_phone, String user_create_time, String comp_name, String team_name, String user_token, String user_img, String user_role) {
        this.user_idx = user_idx;
        this.user_id = user_id;
        this.user_passwd = user_passwd;
        this.user_name = user_name;
        this.user_mail = user_mail;
        this.user_age = user_age;
        this.user_gender = user_gender;
        this.user_birthday = user_birthday;
        this.user_birthyear = user_birthyear;
        this.user_phone = user_phone;
        this.user_create_time = user_create_time;
        this.comp_name = comp_name;
        this.team_name = team_name;
        this.user_token = user_token;
        this.user_img = user_img;
        this.user_role = user_role;
    }
}
