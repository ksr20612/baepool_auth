package com.saminboon.baepool.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_idx;

    @Column
    private String user_id;
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
    private String user_phone;
    @Column
    private String user_create_time;
    @Column(nullable = false)
    private String comp_name;
    @Column(nullable = false)
    private String team_name;
}
