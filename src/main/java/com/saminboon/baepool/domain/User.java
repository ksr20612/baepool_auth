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
    private int userIdx;

    @Column(name = "user_id")
    private String userId;
    @Column(name = "user_passwd")
    private String userPasswd;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_mail")
    private String userMail;
    @Column(name = "user_age")
    private String userAge;
    @Column(name = "user_gender")
    private String userGender;
    @Column(name = "user_birthday")
    private String userBirthday;
    @Column(name = "user_birthyear")
    private String userBirthyear;
    @Column(name = "user_phone")
    private String userPhone;
    @Column(name = "user_create_time")
    private String userCreateTime;
    @Column(name = "comp_name")
    private String compName;
    @Column(name = "team_name")
    private String teamName;
    @Column(name = "user_token")
    private String userToken;
    @Column(name = "user_img")
    private String userImg;
    @Column(name = "user_role")
    private String userRole;

    @Builder
    public User(int userIdx, String userId, String userPasswd, String userName, String userMail, String userAge, String userGender, String userBirthday, String userBirthyear, String userPhone, String userCreateTime, String compName, String teamName, String userToken, String userImg, String userRole) {
        this.userIdx = userIdx;
        this.userId = userId;
        this.userPasswd = userPasswd;
        this.userName = userName;
        this.userMail = userMail;
        this.userAge = userAge;
        this.userGender = userGender;
        this.userBirthday = userBirthday;
        this.userBirthyear = userBirthyear;
        this.userPhone = userPhone;
        this.userCreateTime = userCreateTime;
        this.compName = compName;
        this.teamName = teamName;
        this.userToken = userToken;
        this.userImg = userImg;
        this.userRole = userRole;
    }
}
